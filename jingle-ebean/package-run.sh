#!/usr/bin/env bash

cd ..;
mvn clean package;
#mvn clean package -DskipTests;
java -jar jingle-ebean/target/jingle-ebean-*-exec.jar