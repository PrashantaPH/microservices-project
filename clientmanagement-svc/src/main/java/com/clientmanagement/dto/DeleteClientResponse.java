package com.clientmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;

public class DeleteClientResponse {

    @JsonProperty("delete_client_ids")
    private List<BigInteger> deletedClientIds;
    @JsonProperty("not_found_client_ids")
    private List<BigInteger> notFoundClientIds;

    public DeleteClientResponse() {}

    public DeleteClientResponse(List<BigInteger> deletedClientIds, List<BigInteger> notFoundClientIds) {
        this.deletedClientIds = deletedClientIds;
        this.notFoundClientIds = notFoundClientIds;
    }

    public List<BigInteger> getDeletedClientIds() {
        return deletedClientIds;
    }

    public void setDeletedClientIds(List<BigInteger> deletedClientIds) {
        this.deletedClientIds = deletedClientIds;
    }

    public List<BigInteger> getNotFoundClientIds() {
        return notFoundClientIds;
    }

    public void setNotFoundClientIds(List<BigInteger> notFoundClientIds) {
        this.notFoundClientIds = notFoundClientIds;
    }
}
