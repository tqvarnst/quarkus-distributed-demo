package com.example.distributeddemo.services;

import com.example.distributeddemo.entities.Price;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("price")
@RegisterRestClient(configKey="price.service")
public interface PriceService {

    @GET
    @Path("{salesId}/{country}")
    public Uni<Price> getPriceBySalesIdAndCountry(@PathParam("salesId") String salesId, @PathParam("country") String country);
}
