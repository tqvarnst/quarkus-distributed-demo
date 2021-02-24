package com.example.distributeddemo.services;

import com.example.distributeddemo.entities.Inventory;
import com.example.distributeddemo.repo.InventoryRepository;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

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
    @Blocking
    public Uni<Inventory> getInventoryForWarehouse(@PathParam("salesId") String salesId, @PathParam("warehouseId") String warehouseId) {
        return Uni.createFrom().item(repo.getBySalesIdAndWarehouseId(salesId,warehouseId));
    }
}
