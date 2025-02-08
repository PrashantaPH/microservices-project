package com.clientmanagement.dto;

import com.clientmanagement.model.ClientDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"clients", "pagination"})
public class ClientsResponse {

    @JsonProperty("clients")
    private List<ClientDetails> clientDetailsList;
    @JsonProperty("pagination")
    private PaginationResponse paginationResponse;

    public List<ClientDetails> getClientDetailsList() {
        return clientDetailsList;
    }

    public void setClientDetailsList(List<ClientDetails> clientDetailsList) {
        this.clientDetailsList = clientDetailsList;
    }

    public PaginationResponse getPaginationResponse() {
        return paginationResponse;
    }

    public void setPaginationResponse(PaginationResponse paginationResponse) {
        this.paginationResponse = paginationResponse;
    }
}
