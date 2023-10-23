# Simple e-commerce microservices application

```
The application is built using Spring Boot and Angular, and it uses a microservices architecture to make
it scalable and maintainable.
it contains 4 services :
Customer Service, Inventory Service, Order Service, Billing Service, Config Service
```

# Table of Contents
- [Backend Services](#backend-services)
    - [Config Service](#config-service)
    - [Gateway Service](#gateway-service)
    - [Customer Service](#customer-service)
    - [Inventory Service](#inventory-service)
    - [Order Service](#order-service)
    - [Billing Service](#billing-service)
- [Frontend with Angular](#frontend-with-angular)

# Backend Services

The backend contains 5 services :

## Config Service
`This service contain configuration of all services`

we specify to folder of all config files :

`spring.cloud.config.server.git.uri=file:///D:/config-git-repo`

start the consul server :

`consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=@IP`

To show registred services :

`http://localhost:8500/`

![image](https://github.com/el-moudni-hicham/e-commerce-app-simple/assets/85403056/362f0182-ed31-4478-9f87-71efb2d8e5f4)

## Gateway Service

````
Spring Cloud Gateway It provides a centralized entry point for routing and filtering requests
to microservices in a distributed system, enabling dynamic and scalable routing based on various criteria.
````
we use dynamic routing :

```java
@Bean
DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
    return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
}
```

## Customer Service

* Get all Customers :

![image](https://github.com/el-moudni-hicham/e-commerce-app-simple/assets/85403056/800c75ab-ecdd-484e-86a3-dc196e571330)

## Inventory Service

* Get all Products :

![image](https://github.com/el-moudni-hicham/e-commerce-app-simple/assets/85403056/7b234ff0-eee8-4fff-9b6e-241f835f8c8f)

## Order Service

* Get all infos about an order :

![image](https://github.com/el-moudni-hicham/e-commerce-app-simple/assets/85403056/71e9f90d-9a66-4767-9c67-a1efe72e7e48)

## Billing Service

vault:

`vault server -dev`

`set VAULT_ADDR=http://127.0.0.1:8200`

`vault kv put secret/vault-ms user.username=root user.password=1234`

`vault kv get secret/vault-ms`


# Frontend with Angular

![image](https://github.com/el-moudni-hicham/e-commerce-app-simple/assets/85403056/00354d0e-9a36-4267-b9dc-21929a1f1085)

