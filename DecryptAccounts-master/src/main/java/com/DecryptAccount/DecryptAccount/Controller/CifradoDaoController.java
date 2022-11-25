package com.DecryptAccount.DecryptAccount.Controller;
import com.DecryptAccount.DecryptAccount.Service.CifradoDaoImpl;
import com.DecryptAccount.DecryptAccount.entities.Request;
import com.DecryptAccount.DecryptAccount.entities.RequestList;
import com.DecryptAccount.DecryptAccount.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.var;
@RestController
@RequestMapping("/v1")

public class CifradoDaoController {

    @Autowired
    CifradoDaoImpl cifrado;

    @PostMapping("/getInputService")
    public ResponseEntity<?> getInputService(@RequestBody Request request) throws Exception {
        var a = cifrado.InputService(request);
        return ResponseEntity.ok(a);
    }

    @PostMapping("/DescryptAccount")
    public Response DescryptAccount(@RequestBody Request input) throws Exception {
        var resp = cifrado.InputService(input);
        return resp;
    }

    @PostMapping("/EncripList")
    public ResponseEntity<?> DescryptAccount(@RequestBody RequestList input) throws Exception {
        var result =cifrado.EncripList(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}



