package com.otcp.Accounting.product.service;

import com.otcp.Accounting.product.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    Warehouse saveWarehouse(Warehouse warehouse);
    Warehouse getWarehouseById(Long id);
    List<Warehouse> getAllWarehouses();
    Warehouse updateWarehouse(Long id, Warehouse warehouse);
    void deleteWarehouse(Long id);
}
