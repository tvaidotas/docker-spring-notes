#!/usr/bin/env bash

docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=password -d mysql:latest

docker network create some-network

docker network connect some-network mysql

docker build -t spring-app:latest .

docker run -d -p 8080:8080 --name spring-app spring-app