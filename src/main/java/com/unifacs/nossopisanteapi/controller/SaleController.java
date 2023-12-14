package com.unifacs.nossopisanteapi.controller;

import com.unifacs.nossopisanteapi.model.dto.request.SaleRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.SaleResponseDto;
import com.unifacs.nossopisanteapi.service.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sale")
public class SaleController {
    private final SaleService service;

    @PostMapping
    public ResponseEntity<SaleResponseDto> registerSale(@RequestBody @Valid SaleRequestDto saleRequestDto) {
        return ResponseEntity.status(CREATED).body(service.registerSale(saleRequestDto));
    }
}
