#!/usr/bin/env bash

mvn install
cp ./jingle-common/target/jingle-common-0.1.jar ../../idea/play-demo/lib
ls -lh ../../idea/play-demo/lib