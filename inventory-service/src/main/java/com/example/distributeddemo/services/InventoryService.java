package com.example.distributeddemo.services;

import com.example.distributeddemo.entities.Inventory;
import com.example.distributeddemo.repo.InventoryRepository;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("inventory")
public class InventoryService {

    @Inject
    InventoryRepository repo;

    @GET
    @Path("{salesId}/{warehouseId}")
    @RolesAllowed("user")
    public Inventory getInventoryForWarehouse(@PathParam("salesId") String salesId,@PathParam("warehouseId") String warehouseId) {
        return repo.getBySalesIdAndWarehouseId(salesId,warehouseId);
    }
}
