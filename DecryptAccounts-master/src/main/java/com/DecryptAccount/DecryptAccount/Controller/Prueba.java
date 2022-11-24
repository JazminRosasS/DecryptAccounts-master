package com.DecryptAccount.DecryptAccount.Controller;
import com.DecryptAccount.DecryptAccount.Service.CifradoDaoImpl;
import com.DecryptAccount.DecryptAccount.entities.Request;
import com.DecryptAccount.DecryptAccount.entities.RequestList;
import com.DecryptAccount.DecryptAccount.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")

public class Prueba {

    @Autowired
    CifradoDaoImpl cifrado;

    @PostMapping("/getInputService")
    public ResponseEntity<String> getInputService(@RequestBody Request request) throws Exception {
        cifrado.InputService(request);
        return ResponseEntity.ok("Exitoso");
    }

    @PostMapping("/getDecripList")
    public ResponseEntity<String> getDecripList(@RequestBody RequestList requestlist) throws Exception {
        cifrado.DecripList(requestlist);
        return ResponseEntity.ok("Exitoso");
    }

    @PostMapping("/getEncripList")
    public ResponseEntity<String> getEncripList(@RequestBody RequestList requestlist) throws Exception {
        cifrado.DecripList(requestlist);
        return ResponseEntity.ok("Exitoso");
    }





}



