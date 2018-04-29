#!/usr/bin/env bash

cd ..;
time mvn clean install;
echo -e "\e[31m -----------------------mvn finished-----------------------------\e[0m\n";
#mvn clean package -DskipTests;
java -jar jingle-ebean/target/jingle-ebean-*-exec.jar