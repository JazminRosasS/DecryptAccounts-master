package com.DecryptAccount.DecryptAccount.Service;

import com.DecryptAccount.DecryptAccount.entities.Request;
import com.DecryptAccount.DecryptAccount.entities.RequestList;
import com.DecryptAccount.DecryptAccount.entities.Response;
import com.DecryptAccount.DecryptAccount.entities.ResponseList;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;



@WebService(name="GeneraXML", targetNamespace="http://mx.com.totalplay/")
@Service
public abstract interface GeneraXML {

    @WebResult(name = "ProcessResponse")
    @WebMethod(operationName = "DescryptAccount")
    public abstract Response InputService(@WebParam(name = "Process") Request input) throws Exception;

    @WebResult(name = "Output")
    @WebMethod(operationName = "EncripList")
    public abstract ResponseList EncripList(@WebParam(name = "Input") RequestList input) throws Exception;

    @WebResult(name = "Output")
    @WebMethod(operationName = "DecripList")
    public abstract ResponseList DecripList(@WebParam(name = "Input") RequestList input) throws Exception;

}

