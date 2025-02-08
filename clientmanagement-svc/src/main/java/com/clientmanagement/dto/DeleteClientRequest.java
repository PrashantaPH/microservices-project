package com.clientmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;

public class DeleteClientRequest {

    @JsonProperty("client_ids")
    private List<BigInteger> clientIds;

    public List<BigInteger> getClientIds() {
        return clientIds;
    }

    public void setClientIds(List<BigInteger> clientIds) {
        this.clientIds = clientIds;
    }
}
