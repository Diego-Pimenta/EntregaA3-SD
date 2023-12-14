package com.unifacs.nossopisanteapi.controller;

import com.unifacs.nossopisanteapi.model.dto.response.ReportConsumptionByClient;
import com.unifacs.nossopisanteapi.model.dto.response.ReportLowStockProducts;
import com.unifacs.nossopisanteapi.model.dto.response.ReportMostSoldProduct;
import com.unifacs.nossopisanteapi.model.dto.response.ReportProductByClient;
import com.unifacs.nossopisanteapi.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    private final ReportService service;

    @GetMapping("/most-sold-product")
    public ResponseEntity<ReportMostSoldProduct> getMostSoldProduct() {
        return ResponseEntity.ok(service.getMostSoldProduct());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ReportProductByClient> getProductByClient(@PathVariable("id") UUID clientId) {
        return ResponseEntity.ok(service.getProductByClient(clientId));
    }

    @GetMapping("/consumption/{id}")
    public ResponseEntity<ReportConsumptionByClient> getConsumptionByClient(@PathVariable("id") UUID clientId) {
        return ResponseEntity.ok(service.getConsumptionByClient(clientId));
    }

    @GetMapping("/low-stock-products")
    public ResponseEntity<ReportLowStockProducts> getLowStockProducts() {
        return ResponseEntity.ok(service.getLowStockProducts());
    }

}
