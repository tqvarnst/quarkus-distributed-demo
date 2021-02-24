package com.example.frontend;

import com.example.distributeddemo.entities.Product;
import com.example.distributeddemo.repo.ProductRepository;
import com.example.distributeddemo.services.PriceService;
import io.quarkus.panache.common.Sort;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/")
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.TEXT_HTML)
public class TemplateService {

    @Inject
    Template home;

    @Inject
    ProductRepository repo;

    @Inject
    @RestClient
    PriceService priceService;

    @GET
    @PermitAll
    public TemplateInstance start(@QueryParam("country") Optional<String> country) {

        List<Product> products = repo.listAll(Sort.ascending("creationDate"));
        products.stream().forEach(p -> {
            p.setPriceDetails(priceService.getPriceBySalesIdAndCountry(p.getSalesId(),country.orElse("SE")));
        });

        return home.instance().data("products",products).data("country",country.orElse("SE"));
    }
}
