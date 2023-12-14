package com.unifacs.nossopisanteapi.service;

import com.unifacs.nossopisanteapi.model.dto.request.SaleRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.SaleResponseDto;

public interface SaleService {
    SaleResponseDto registerSale(SaleRequestDto saleRequestDto);
}
