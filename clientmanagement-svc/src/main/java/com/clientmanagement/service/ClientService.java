package com.clientmanagement.service;

import com.clientmanagement.dto.*;
import com.clientmanagement.exception.ClientNotFoundException;
import com.clientmanagement.exception.DuplicateClientException;
import com.clientmanagement.model.ClientDetails;
import com.clientmanagement.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @CacheEvict(value = "clients", allEntries = true)
    public void createClientDetails(String loggedInUser, ClientDetails clientDetails) {
        Optional<ClientDetails> optional = clientRepository.findByEntityName(clientDetails.getEntityName());
        if (optional.isPresent()) {
            LOGGER.info("Client already exists {}", clientDetails.getEntityName());
            throw new DuplicateClientException("Client already exists");
        }
        if (clientRepository.existsByEmailId(clientDetails.getEmailId())) {
            LOGGER.info("Client already exists {}", clientDetails.getEmailId());
            throw new DuplicateClientException("Client already exists");
        }
        if (clientRepository.existsByTelephoneNumber(clientDetails.getTelephoneNumber())) {
            LOGGER.info("Client already exists");
            throw new DuplicateClientException("Client already exists");
        }
        if (clientRepository.existsByTaxRegistrationNumber1(clientDetails.getTaxRegistrationNumber1())) {
            LOGGER.info("Client already exists");
            throw new DuplicateClientException("Client already exists");
        }
        clientDetails.setCreatedBy(loggedInUser);
        clientDetails.setCreatedOn(LocalDateTime.now().toString());
        clientRepository.save(clientDetails);
    }

    //we can use @CachePut also
    @Cacheable(value = "clients", key = "#request.pageSize + '-' + #request.pageNumber + '-' + #request.sortBy + '-' +#request.sortDirection + '-' + #request.searchString")
    public ClientsResponse getClientDetailsList(PaginationRequest request) {
        ClientsResponse response = new ClientsResponse();
        Sort.Direction direction = Sort.Direction.fromString(request.getSortDirection());
        Sort sort = Sort.by(direction, request.getSortBy());

        Pageable pageable = PageRequest.of(request.getPageNumber() - 1, request.getPageSize(), sort);
        Page<ClientDetails> clientDetailsPage = null;
        if (request.getSearchString() != null) {
             clientDetailsPage = clientRepository.findByEntityNameContainingIgnoreCase(request.getSearchString(), pageable);
        } else {
            clientDetailsPage = clientRepository.findAll(pageable);
        }

        response.setClientDetailsList(clientDetailsPage.getContent());
        response.setPaginationResponse(getPaginationResponse(clientDetailsPage));
        return response;
    }

    @Cacheable(value = "clients", key = "#clientId")
    public ClientDetails getClientDetails(BigInteger clientId) {
        return getClientData(clientId);
    }

    @CacheEvict(value = "clients", key = "#clientId")
    public void deleteClientDetails(BigInteger clientId) {
        clientRepository.delete(getClientData(clientId));
    }

    public DeleteClientResponse deleteClientsDetails(DeleteClientRequest request) {
        List<ClientDetails> clientDetailsList = clientRepository.findAllById(request.getClientIds());
        if (clientDetailsList.isEmpty()) {
            LOGGER.info("Clients not found - {}", request.getClientIds());
            throw new ClientNotFoundException("Clients not found");
        }
        List<BigInteger> foundClientIds = clientDetailsList.stream()
                .map(obj -> obj.getClientId())
                .toList();
        List<BigInteger> notFoundClientIds = request.getClientIds().stream()
                .filter(id -> !foundClientIds.contains(id))
                .toList();

        clientRepository.deleteAll(clientDetailsList);
        return new DeleteClientResponse(foundClientIds, notFoundClientIds);
    }

    private ClientDetails getClientData(BigInteger clientId) {
        Optional<ClientDetails> clientDetails = clientRepository.findById(clientId);
        if (clientDetails.isEmpty()) {
            LOGGER.info("Client not found - {}", clientId);
            throw new ClientNotFoundException("Client not found");
        }
        return clientDetails.get();
    }

    private PaginationResponse getPaginationResponse(Page<ClientDetails> clientDetailsPage) {
        PaginationResponse response = new PaginationResponse();
        response.setPageSize(clientDetailsPage.getSize());
        response.setPageNumber(clientDetailsPage.getNumber() + 1);
        response.setNoOfPages(clientDetailsPage.getTotalPages());
        response.setTotalResults(clientDetailsPage.getTotalElements());
        return response;
    }

}
