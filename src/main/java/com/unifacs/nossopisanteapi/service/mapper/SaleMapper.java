package com.unifacs.nossopisanteapi.service.mapper;

import com.unifacs.nossopisanteapi.model.dto.request.SaleRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.SaleResponseDto;
import com.unifacs.nossopisanteapi.model.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", uses = {ProductStockMapper.class, ClientMapper.class}, unmappedTargetPolicy = IGNORE)
public interface SaleMapper {
    @Mapping(target = "soldAt", expression = "java(LocalDateTime.now())")
    Sale saleRequestDtoToSale(SaleRequestDto saleRequestDto);

    SaleResponseDto saleToSaleResponseDto(Sale sale);
}
