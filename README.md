This project uses Quarkus, the Supersonic Subatomic Java Framework.

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