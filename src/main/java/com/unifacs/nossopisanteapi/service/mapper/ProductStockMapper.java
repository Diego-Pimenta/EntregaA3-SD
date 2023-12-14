package com.unifacs.nossopisanteapi.service.mapper;

import com.unifacs.nossopisanteapi.model.dto.request.CreateProductStockRequestDto;
import com.unifacs.nossopisanteapi.model.dto.request.UpdateProductStockRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.ProductStockResponseDto;
import com.unifacs.nossopisanteapi.model.entity.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Mapper(componentModel = "spring", imports = { StringUtils.class, Objects.class })
public interface ProductStockMapper {
    ProductStock createProductStockRequestDtoToProduct(CreateProductStockRequestDto createProductStockRequestDto);

    ProductStockResponseDto productStockToProductStockResponseDto(ProductStock productStock);

    @Mapping(
        target = "nameProduct",
        expression = "java(StringUtils.hasText(updateProductStockRequestDto.nameProduct()) ? updateProductStockRequestDto.nameProduct() : productStock.getNameProduct())"
    )
    @Mapping(
        target = "quantity",
        expression = "java(!Objects.isNull(updateProductStockRequestDto.quantity()) ? updateProductStockRequestDto.quantity() : productStock.getQuantity())"
    )
    @Mapping(
        target = "brand",
        expression = "java(StringUtils.hasText(updateProductStockRequestDto.brand()) ? updateProductStockRequestDto.brand() : productStock.getBrand())"
    )
    @Mapping(
        target = "price",
        expression = "java(!Objects.isNull(updateProductStockRequestDto.price()) ? updateProductStockRequestDto.price() : productStock.getPrice())"
    )
    @Mapping(
        target = "category",
        expression = "java(StringUtils.hasText(updateProductStockRequestDto.category()) ? updateProductStockRequestDto.category() : productStock.getCategory())"
    )
    ProductStock updateProductStockRequestDtoToProductStock(ProductStock productStock, UpdateProductStockRequestDto updateProductStockRequestDto);
}
