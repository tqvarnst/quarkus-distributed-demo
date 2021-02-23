package com.example.distributeddemo.repo;

import com.example.distributeddemo.entities.Inventory;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventoryRepository implements PanacheRepository<Inventory> {

    public Inventory getBySalesIdAndWarehouseId(String salesId, String warehouseId) {
        return find("salesId=?1 and warehouse_id=?2",salesId,warehouseId).firstResult();
    }
}
