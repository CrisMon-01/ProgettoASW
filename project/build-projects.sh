#!/bin/bash

echo Building Java projects
gradle assemble

echo Building images
docker-compose build



