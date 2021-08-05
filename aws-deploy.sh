#!/bin/bash
#This script we are using to start application in the AWS
export INSTANCE_HOST=ec2-18-208-195-255.compute-1.amazonaws.com
export CERTIFICATE_PASS=C:/Users/Oleksandr_Yanov1/Desktop/GoIT/DEV_COURSE/aws/goit.pem
export SPRING_PROFILE=aws

gradle build
echo "project builded"
scp -i $CERTIFICATE_PASS build/libs/library-1.0.war ec2-user@$INSTANCE_HOST:/tmp
echo "war copied to the AWS"
ssh -i $CERTIFICATE_PASS ec2-user@$INSTANCE_HOST /bin/bash << EOF
    echo "logged in to the AWS"
    cd /tmp
    sudo su
    nohup java -Dspring.profiles.active=$SPRING_PROFILE -jar library-1.0.war > log.log 2>&1 &
    echo "started application"
EOF
