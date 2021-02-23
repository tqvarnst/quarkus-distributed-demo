package com.example.distributeddemo.services;


import com.example.distributeddemo.entities.Price;
import com.example.distributeddemo.entities.Product;
import com.example.distributeddemo.repo.ProductRepository;
import io.quarkus.panache.common.Sort;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.security.RolesAllowed;
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

    @GET
    public List<Product> getAll() {
        List<Product> products = repo.listAll(Sort.ascending("creationDate"));
        return products;
    }

    @GET
    @Path("price/{country}")
    @RolesAllowed("user")
    public List<Product> getProductsWithPrice(@PathParam("country") String country) {
        List<Product> products = repo.listAll(Sort.ascending("creationDate"));
        products.stream().forEach(p -> {
            p.setPriceDetails(priceService.getPriceBySalesIdAndCountry(p.getSalesId(),country));
        });
        return products;
    }


    @GET
    @Path("{id}")
    public Product getById(@PathParam("id") Long id) {
        Product product = repo.findById(id);
        if(product!=null) {
            product.setPriceDetails(priceService.getPriceBySalesIdAndCountry(product.getSalesId(),"SE"));
        }
        return product;
    }

    @GET
    @Path("filter")
    public List<Product> filterByDate(@QueryParam("from") String from, @QueryParam("to") String to) throws ParseException {
        Date fromDate = formatter.parse(from);
        Date toDate = formatter.parse(to);
        List<Product> products = repo.find("creationDate > ?1 and creationDate < ?2", fromDate, toDate).list();
        products.stream().forEach(p -> {
            p.setPriceDetails(priceService.getPriceBySalesIdAndCountry(p.getSalesId(),"SE"));
        });
        return products;
    }
}
