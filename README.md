# Distributed Pattern Basic REST service using MicroProfile 

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the demo

```shell script
./mvnw clean package
docker-compose up -d --build
```

This starts 3 different containers matching the application described in the main branch. To verify use curl or HTTPie (used in the instructions)

```shell script
http :8080/products
```

The above command will list products in the product service without touching price and inventory service.

To get the same list of products but with price information you can use

```shell script
http :8080/products/price/SE
```

Finally, to the the inventory for a product use the salesId of one of the products listed previously and run the following command.

```shell script
http :8080/products/inventory/<salesid>/DE
```

When you are done run `docker-compose down` to stop and remove the containers.

