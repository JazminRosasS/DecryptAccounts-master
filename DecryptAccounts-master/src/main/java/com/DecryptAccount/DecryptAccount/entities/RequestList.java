package com.DecryptAccount.DecryptAccount.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RequestList {
    @JsonProperty("inputList")
    private List<String> inputList;
    @JsonProperty("privatekey")
    private String privatekey;
    @JsonProperty("publicKey")
    private String publicKey;
}



