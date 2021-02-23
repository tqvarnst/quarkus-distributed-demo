package com.example.distributeddemo.services;

import com.example.distributeddemo.entities.Inventory;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("inventory")
@RegisterRestClient(configKey="inventory.service")
public interface InventoryService {

    @GET
    @Path("{salesId}/{warehouseId}")
    public Inventory getInventoryBySalesIdAndWarehouseId(@PathParam("salesId") String salesId, @PathParam("warehouseId") String warehouseId);
}
