#!/bin/bash

cd ..

npm install

npm run build

cp -r dist/ docker/dist/

cd docker

docker build -t dynamic-burger-web .

docker run -d -p 4200:80 --name dynamic-burger-web -t dynamic-burger-web
