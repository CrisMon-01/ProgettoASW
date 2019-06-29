#!/bin/bash

echo Building Java projects
gradle assemble

echo Building Docker images
docker-compose build



