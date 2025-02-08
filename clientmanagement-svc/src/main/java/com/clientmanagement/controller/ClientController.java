package com.clientmanagement.controller;

import com.clientmanagement.annotations.ValidClient;
import com.clientmanagement.dto.*;
import com.clientmanagement.model.ClientDetails;
import com.clientmanagement.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

import static com.clientmanagement.util.ClientUtil.*;
import static com.clientmanagement.util.ClientsConstants.*;

@RestController
@RequestMapping("/v1/api/clients")
@Validated
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("create")
    public ResponseEntity<ApiResponse<ClientDetails>> createClient(@RequestHeader("loggedInUser") String loggedInUser,
                                                                   @RequestBody @ValidClient(operation = CREATE) ClientDetails clientDetails) {
        clientService.createClientDetails(loggedInUser, clientDetails);
        return successObject("Client created successfully");
    }

    @PostMapping("/list")
    public ResponseEntity<ApiResponse<ClientsResponse>> getClients(@RequestBody PaginationRequest request) {
        var response = clientService.getClientDetailsList(request);
        return successObject("Clients fetched successfully", response);
    }

    @GetMapping("/{client_id}")
    public ResponseEntity<ApiResponse<ClientDetails>> getClient(@PathVariable("client_id") BigInteger clientId) {
        var response = clientService.getClientDetails(clientId);
        return successObject("Client fetched successfully", response);
    }

    @DeleteMapping("/{client_id}")
    public ResponseEntity<ApiResponse<ClientDetails>> deleteClient(@PathVariable("client_id") BigInteger clientId) {
        clientService.deleteClientDetails(clientId);
        return successObject("Client deleted successfully");
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponse<DeleteClientResponse>> deleteClients(@RequestBody DeleteClientRequest request) {
        var response = clientService.deleteClientsDetails(request);
        return successObject("Clients deleted successfully", response);
    }
}
