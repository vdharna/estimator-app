#!/bin/sh
echo "********************************************************"
echo "Starting Configuration Server"
echo "********************************************************"
java -jar /usr/local/configuration-server/@project.build.finalName@.jar
