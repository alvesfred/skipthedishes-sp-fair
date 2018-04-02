# SkipTheDishes Challenge Project

Author: Frederico Cerqueira Alves

SkipTheDishes SP Fair - Senior Java Developer

# Spring Boot Project:

- Responsible for controlling orders, customers and products from a specific store

- Patterns used:

Repository, 
Service, 
Resource (Rest WebServices), 
In memory cache (Hazelcast),
Invertion of Control

# Frameworks/APIs

Spring Boot, 
Spring Rest, 
Spring Test, 
Spring Scheduler,
Swagger,
Hazelcast, 
Hibernate,
Lombok,
JUnit

# MySQL version 5.5

Docker

$ sudo docker run --name skipthedishes-sp-fair -p 3306:3306 -e MYSQL_ROOT_PASSWORD=${pwd} -d mysql:5.5

$ sudo docker exec -it skipthedishes-sp-fair bash

$ sudo docker run -it --link skipthedishes-sp-fair:mysql --rm mysql sh -c 'exec mysql -h "$IP" -P "3306" -uroot -p"$pwd"'

NOTE: see the application.yml for additional configuration

# Tests

mvn clean install

# Documentation

http://${HOST}:8080/swagger-ui.htm
