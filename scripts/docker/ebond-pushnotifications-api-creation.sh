#!/bin/sh

## create service image
docker build -t verizon/ebond-pushnotifications-api .

## setup network for containers
docker network create ebond-pushnotifications-api

## Container creation
docker create --name ebond-pushnotifications-api-db -p 6379:6379 --net=ebond-pushnotifications-api redis
docker create --name ebond-pushnotifications-api -p 8080:9999 -it --net=ebond-pushnotifications-api -v $(pwd):/var/www verizon/ebond-pushnotifications-api