package com.unifacs.nossopisanteapi.repository;

import com.unifacs.nossopisanteapi.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {
}
