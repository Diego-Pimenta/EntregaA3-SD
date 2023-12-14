package com.unifacs.nossopisanteapi.service;

import com.unifacs.nossopisanteapi.model.dto.response.ReportConsumptionByClient;
import com.unifacs.nossopisanteapi.model.dto.response.ReportLowStockProducts;
import com.unifacs.nossopisanteapi.model.dto.response.ReportMostSoldProduct;
import com.unifacs.nossopisanteapi.model.dto.response.ReportProductByClient;

import java.util.UUID;

public interface ReportService {
    ReportMostSoldProduct getMostSoldProduct();
    ReportProductByClient getProductByClient(UUID clientId);
    ReportConsumptionByClient getConsumptionByClient(UUID clientId);
    ReportLowStockProducts getLowStockProducts();
}
