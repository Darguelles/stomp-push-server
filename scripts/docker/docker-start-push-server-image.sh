#!/bin/sh

## start containers
docker start ebond-pushnotifications-api-db
docker start ebond-pushnotifications-api

## get into main container
docker exec -it ebond-pushnotifications-api /bin/bash

