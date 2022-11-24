package com.DecryptAccount.DecryptAccount.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @JsonProperty("accountNo")
    private String accountNo;
    @JsonProperty("privatekey")
    private String privatekey;
    @JsonProperty("publicKey")
    private String publicKey;

}
