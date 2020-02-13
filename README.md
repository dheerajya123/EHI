# Steps to build in Docker container in Linux

Clone the current project in local directory

Open EHI folder

Run ./build.sh

Run this command:-  docker run -p 8086:8086 java -jar /application/EHIProject-0.0.1-SNAPSHOT.jar

Hit the url on browser:- http://localhost:8086

# steps to build in windows

Open EHI folder

Go to EHIProject\target

Run the command:- java -jar EHIProject-0.0.1-SNAPSHOT.jar

Hit the url on browser:- http://localhost:8086

