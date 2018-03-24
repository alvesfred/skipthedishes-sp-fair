# SkipTheDishes Challenge Project

Author: Frederico Cerqueira Alves

SkipTheDishes - Java Developer

# Spring Boot Project:

https://github.com/alvesfred/skipthedishes-sp-fair

- Responsible for controlling orders, customers and products from a specific store

- Patterns used:

Repository, 
Service, 
Resource (Rest WebServices), 
In memory cache (Hazelcast)

# Frameworks/APIs

Hazelcast api, 
Spring Boot, 
Spring Rest, 
Spring Test, 
Spring Scheduler, 
Lombok, 
JUnit

# MySQL version 5.5

$ Docker: sudo docker run --name skipthedishes-sp-fair -p 3306:3306 -e MYSQL_ROOT_PASSWORD=${pwd} -d mysql:5.5

$ docker exec -it skipthedishes-sp-fair bash

NOTE: see the application.yml for additional configuration

# TODO LIST...

- Token Authentication from Resource calls
- Tests

