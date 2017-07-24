#!/bin/bash

cd ..

mvn package

cp target/dynamic-burger-0.0.1-SNAPSHOT.jar docker/dynamic-burger-0.0.1-SNAPSHOT.jar

cd docker

docker build -t dynamic-burger-api --build-arg artifact=dynamic-burger-0.0.1-SNAPSHOT.jar .

docker run -d -p 8080:8080 --name dynamic-burger-api -t dynamic-burger-api
