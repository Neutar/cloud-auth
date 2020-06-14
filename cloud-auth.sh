#!/bin/bash

mvn clean package

docker build -f docker/Dockerfile . -t cloud-auth