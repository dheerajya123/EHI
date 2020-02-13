#This is a sample Image 
FROM centos:latest

RUN  yum -y install java-1.8.0-openjdk 

RUN mkdir application

COPY EHIProject/target/EHIProject-0.0.1-SNAPSHOT.jar application/
