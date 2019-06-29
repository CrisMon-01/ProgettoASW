#!/bin/bash

source "/home/ProgettoASW/shared/scripts/common.sh"

# see https://openjdk.java.net/install/ 

# set up the Java constants 
OPENJDK_PACKAGE=openjdk-8-jdk

echo "====================="
echo "installing open jdk 8"
echo "====================="

apt update 
apt install -y ${OPENJDK_PACKAGE}
