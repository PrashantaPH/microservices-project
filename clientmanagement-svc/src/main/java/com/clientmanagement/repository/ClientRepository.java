package com.clientmanagement.repository;

import com.clientmanagement.model.ClientDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientDetails, BigInteger> {

    Optional<ClientDetails> findByEntityName(String entityName);

    boolean existsByEmailId(String emailId);

    boolean existsByTelephoneNumber(String telephoneNumber);

    boolean existsByTaxRegistrationNumber1(String taxRegistrationNumber1);

    Page<ClientDetails> findByEntityNameContainingIgnoreCase(String searchString, Pageable pageable);
}
