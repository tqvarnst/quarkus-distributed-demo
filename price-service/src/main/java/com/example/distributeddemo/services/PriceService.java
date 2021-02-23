package com.example.distributeddemo.services;

import com.example.distributeddemo.entities.Price;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("price")
@RolesAllowed("partners,admin,internal")
public class PriceService {

    @GET
    @Path("{salesId}/{country}")
    public Price getPriceFromSalesId(@PathParam("salesId") String salesId,@PathParam("country") String country) {
        return Price.find("salesId = ?1 and country = ?2",salesId,country).firstResult();
    }

    @GET
    public List<Price> getAllPrices() {
        return Price.listAll();
    }
}
