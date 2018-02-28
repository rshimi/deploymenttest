#!/bin/bash

REGION=us-west-2
APPLICATION_NAME=HelloWorldDockerAWS

APPLICATIONS=`aws elasticbeanstalk describe-applications --application-names ${APPLICATION_NAME}`

if [ "$APPLICATIONS" == "" ]
then
    echo "deploying to an existing application"
    aws elasticbeanstalk update-application --application-name ${APPLICATION_NAME}
else
    echo "createing a new application"
    aws elasticbeanstalk create-application --application-name ${APPLICATION_NAME} --region ${REGION}
fi