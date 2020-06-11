#!/bin/bash

echo "Starting logstash..."
echo "Logstash needs java 8 to run"

cd /opt/elk/logstash/logstash-7.5.2
bin/logstash -f beats-billing.conf
