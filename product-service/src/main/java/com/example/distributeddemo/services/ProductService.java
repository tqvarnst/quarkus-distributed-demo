package com.example.distributeddemo.services;


import com.example.distributeddemo.entities.Inventory;
import com.example.distributeddemo.entities.Product;
import com.example.distributeddemo.repo.ProductRepository;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Path("products")
@Consumes("application/json")
@Produces("application/json")
public class ProductService {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd", Locale.ENGLISH);

    @Inject
    ProductRepository repo;

    @Inject
    @RestClient
    PriceService priceService;

    @Inject
    @RestClient
    InventoryService inventoryService;

    @GET
    public List<Product> getAll() {
        List<Product> products = repo.listAll(Sort.ascending("creationDate"));
        return products;
    }

    @GET
    @Path("price/{country}")
    public Multi<Product> getProductsWithPrice(@PathParam("country") String country) {
        return  Multi.createFrom()
                    .items(repo.streamAll(Sort.ascending("creationDate")))
                    .onItem()
                    .transformToUniAndMerge(p ->
                        priceService.getPriceBySalesIdAndCountry(p.getSalesId(),country)
                                .map(p2 -> {
                                    p.setPriceDetails(p2);
                                    return p;
                                })
                    );
    }


    @GET
    @Path("{id}")
    public Product getById(@PathParam("id") Long id) {
        Product product = repo.findById(id);
        return product;
    }

    @GET
    @Path("inventory/{salesId}/{warehouseId}")
    public Uni<Inventory> getInventory(@PathParam("salesId") String salesId, @PathParam("warehouseId") String warehouseId) {
        return inventoryService.getInventoryBySalesIdAndWarehouseId(salesId,warehouseId);
    }


    @GET
    @Path("filter")
    public List<Product> filterByDate(@QueryParam("from") String from, @QueryParam("to") String to) throws ParseException {
        Date fromDate = formatter.parse(from);
        Date toDate = formatter.parse(to);
        List<Product> products = repo.find("creationDate > ?1 and creationDate < ?2", fromDate, toDate).list();
        return products;
    }
}
