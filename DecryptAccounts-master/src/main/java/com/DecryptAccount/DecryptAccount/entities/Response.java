package com.DecryptAccount.DecryptAccount.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Response {
    @JsonProperty("accountNo")
    private String accountNo;
    @JsonProperty("result")
    private String result;
    @JsonProperty("resultDescription")
    private String resultDescription;
}


