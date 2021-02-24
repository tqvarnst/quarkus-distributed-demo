package com.example.distributeddemo.services;

import com.example.distributeddemo.entities.Price;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("price")
@RolesAllowed("partners,admin,internal")
public class PriceService {

    @GET
    @Path("{salesId}/{country}")
    @Blocking
    public Uni<Price> getPriceFromSalesId(@PathParam("salesId") String salesId, @PathParam("country") String country) {
        return Uni.createFrom().item((Price) Price.find("salesId = ?1 and country = ?2",salesId,country).firstResult());
    }

    @GET
    @Blocking
    public Multi<Price> getAllPrices() {
        return Multi.createFrom().items(Price.streamAll());
    }
}
