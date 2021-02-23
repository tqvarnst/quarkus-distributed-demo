# Distributed Pattern Secure REST service using JWT 

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the demo

First build and deploy a Keycloak server

```shell script
./mvnw clean package
docker-compose build
docker-compose up -d keycloak
docker-compose logs -f
```

Wait for the keycloak server to come up then start the rest of the services

```shell script
docker-compose up -d
```

This starts 3 different containers matching the application described in the main branch. To verify use curl or HTTPie (used in the instructions)

```shell script
http :8080/products
```

Note that the above command returns as expected. However, let's now assume that in order to see list with prices included you have to be authenticated. 

Try running
```shell script
http :8080/products/price/SE
```
This should result in a HTTP 401 Unauthorized response since this service requires authentication of a user with the role `user`

To identify us to the service we first need to optain a token. We can do that by issuing a login call to the keycloak service like this.

```shell script
export access_token=$(\
    curl -X POST http://localhost:8180/auth/realms/quarkus/protocol/openid-connect/token \
    --user backend-service:secret \
    -H 'content-type: application/x-www-form-urlencoded' \
    -d 'username=alice&password=alice&grant_type=password' | jq --raw-output '.access_token' \
 )
```

Now verify that we have received a token `echo $access_token`

This should print our access token on the command line.

We can use the access token while calling the price list endpoint like this.

```shell script
http :8080/products/price/SE "Authorization: Bearer $access_token"
``` 

What is happening in the background is that the product service will recieve the call with the access token in the Header and will then contact Keycloak to verify that it's correct. After that it will get the list of products form the database and then call the price service passing along the same JWT access token to price service. The price service will then again verify that the token is correct and if valid return the price.

Also the inventory service is secured and require a JWT access token. To test this run the following command:

```shell script
http :8080/products/inventory/FRUIT_00003/DE "Authorization: Bearer $access_token"
```

When you are done run `docker-compose down`

