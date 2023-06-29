#!/bin/bash

mvn compile

mvn exec:java -Dexec.mainClass="ApiDelivery.App"