package com.DecryptAccount.DecryptAccount.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseList {
    @JsonProperty("outputList")
    private List<String> outputList;
    @JsonProperty("result")
    private String result;
    @JsonProperty("resultDescription")
    private String resultDescription;


}
