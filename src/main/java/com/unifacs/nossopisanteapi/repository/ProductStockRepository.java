package com.unifacs.nossopisanteapi.repository;

import com.unifacs.nossopisanteapi.model.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductStockRepository extends JpaRepository<ProductStock, UUID> {
}
