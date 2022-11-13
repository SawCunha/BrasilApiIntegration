#!/bin/bash

mvn clean install

mkdir -p deploy
cp core/target/BrasilAPIIntegrationCore.jar deploy/BrasilAPIIntegrationCore.jar
cp feign/target/BrasilAPIIntegrationFeign.jar deploy/BrasilAPIIntegrationFeign.jar