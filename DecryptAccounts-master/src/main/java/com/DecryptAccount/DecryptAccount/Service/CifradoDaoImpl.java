package com.DecryptAccount.DecryptAccount.Service;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import com.DecryptAccount.DecryptAccount.entities.Request;
import com.DecryptAccount.DecryptAccount.entities.RequestList;
import com.DecryptAccount.DecryptAccount.entities.Response;
import com.DecryptAccount.DecryptAccount.entities.ResponseList;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class CifradoDaoImpl  {
    @SuppressWarnings("unused")
    private Cipher cipher;

    public Response InputService(Request input) throws Exception {

        Response resp = new Response();

        String Account = input.getAccountNo();
        String privatekey = input.getPrivatekey();
        String publickey = input.getPublicKey();

        PrivateKey pvkey = createKeyPrivate(privatekey);
        PublicKey keyPublic = createKeyPublic(publickey);

        String accountDes = decryptMessage(Account, pvkey);
        String accountEn = encryptMessage(accountDes, keyPublic);


        System.out.println("Valor Cuenta Encriptadaaaaa: " + accountEn);
        System.out.println("Valor Cuenta Desencriptadaaaaa: " + accountDes);

        resp.setAccountNo(accountDes);
        resp.setResult("0");
        resp.setResultDescription("Consulta Exitosa");

        return resp;

    }

    public ResponseList DecripList(RequestList input) throws Exception {

        ResponseList resp = new ResponseList();

        List<String> inputList = input.getInputList();
        String privatekey = input.getPrivatekey();
        PrivateKey pvkey = createKeyPrivate(privatekey);

        List<String> outputList = new ArrayList<>();

        Iterator<String> itList = inputList.iterator();
        while (itList.hasNext()) {
            String txtEncrip = itList.next();
            String txtDecrip = decryptMessage(txtEncrip, pvkey);
            outputList.add(txtDecrip);
        }

        resp.setOutputList(outputList);
        resp.setResult("0");
        resp.setResultDescription("Consulta Exitosa");

        return resp;
    }

    public ResponseList EncripList(RequestList input) throws Exception {

        ResponseList resp = new ResponseList();

        List<String> inputList = input.getInputList();
        String publickey = input.getPublicKey();
        PublicKey keyPublic = createKeyPublic(publickey);

        List<String> outputList = new ArrayList<>();

        Iterator<String> itList = inputList.iterator();
        while (itList.hasNext()) {
            String txtDecrip = itList.next();
            String txtEncrip = encryptMessage(txtDecrip, keyPublic);
            outputList.add(txtEncrip);
        }

        resp.setOutputList(outputList);
        resp.setResult("0");
        resp.setResultDescription("Consulta Exitosa");

        return resp;
    }

    public PrivateKey createKeyPrivate(String privatekey) {
        byte[] keyPriv = Base64.decodeBase64(privatekey);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyPriv);
        PrivateKey privKy = null;
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            privKy = kf.generatePrivate(spec);
        } catch (InvalidKeySpecException|NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return privKy;
    }

    public PublicKey createKeyPublic(String publickey) {
        byte[] keyPub = Base64.decodeBase64(publickey);
        PublicKey pubKey = null;
        try {
            this.cipher = Cipher.getInstance("RSA");
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyPub);

            KeyFactory kf = KeyFactory.getInstance("RSA");
            pubKey = kf.generatePublic(spec);
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        } catch (InvalidKeySpecException e) {

            e.printStackTrace();
        } catch (NoSuchPaddingException e) {

            e.printStackTrace();
        }

        return pubKey;
    }

    public String decryptMessage(String encryptedText, PrivateKey privKy) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, privKy);
        return new String(cipher.doFinal(Base64.decodeBase64(encryptedText)));
    }

    public String encryptMessage(String plainText, PublicKey pubKy) {

        String encriptado = "";
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(1, pubKy);
            encriptado = Base64.encodeBase64String(cipher.doFinal(plainText.getBytes()));
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        } catch (NoSuchPaddingException e) {

            e.printStackTrace();
        } catch (InvalidKeyException e) {

            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {

            e.printStackTrace();
        } catch (BadPaddingException e) {

            e.printStackTrace();
        }

        return encriptado;
    }

}
