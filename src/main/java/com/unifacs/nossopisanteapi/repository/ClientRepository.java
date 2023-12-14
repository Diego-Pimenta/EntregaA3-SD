package com.unifacs.nossopisanteapi.repository;

import com.unifacs.nossopisanteapi.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
