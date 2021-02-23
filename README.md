# Building distributed applications with Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

To build distributed applications there are some common patterns that are used. It's beyond the scope of this demo to discuss which pattern is best in different situation, but instead this demo focuses on showing some common patterns.

The patterns covered in this demo are:

* Basic MicroProfile REST services
* Secure MicroProfile REST services using JWT
* Reactive REST services
* Event Driven services using Kafka
 
## The demo Application

The demo application consist of three different services.

1. **Price service** - This service is responsible for returning a price in the local currency based on salesId (product identifier) and country code.
2. **Inventory service** - The inventory service returns the current stock count for a certain product based on salesId (product identifier) and the warehouseId.
3. **Product service** - The product service is the public facing API service and besides returning which products are currently for sales it also integrates with the price service and inventory service to expose endpoints that give price and inventory information about products. 

<pre>
                          ^
                          |
                    +------------+
                    |   Product  |
                    +------------+
                          |
                 +--------------------+                    
                 |                    |
           +-----------+          +-----------+
           |   Price   |          | Inventory |
           +-----------+          +-----------+
</pre>

### Running the demo locally
To run the demo locally please checkout the branch showing the relative patterns - The patterns are:

| Pattern | Branch |
|---------|--------|
|Basic MicroProfile REST services|**basic-rest**|
|Secure MicroProfile REST services using JWT|**secure-rest**|
|Reactive REST services||
|Event Driven services using Kafka||

To run the demo checkout the relevant branch and read the instructions in the README.md

For example:

`git checkout basic-rest`



### Deploying the project to OpenShift

*NOTE: This currently doesn't work with the `secure-rest` branch*

You just started working with Quarkus and you want to try out how to deploy your application on Openshift. This project uses the Github actions and deploys this barebones app onto the [Red Hat Developer Sandbox for Openshift](https://developers.rehdat.com/developer-sandbox)

To deploy this project on the Sandbox, make sure you setup 3 secrets in your github repo.
- OPENSHIFT_SERVER_URL
- OPENSHIFT_NAMESPACE
- OPENSHIFT_TOKEN

Once logged into your new Openshift Console click on the right-hand corner where it states your login name, and then "Copy login command"

You will find the token and the server url at that link.
e.g.

```
oc login --token=XXXX --server=https://api.XXX.openshiftapps.com:6443
```

Dont forget to add the namespace you want to deploy to. in my case I use the `-dev` namespace.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

