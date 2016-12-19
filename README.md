# Vendor E-bonding Push Notifications API
This is the Repository for E-bonding Push Notifications API application. 

## Project Structure

    /scripts
        /docker
        /deploy
    /src
        /main
            /java
            /resource
        /test
            /java
            /resources

* /scripts/docker -> This folder is used to maintain the Docker script files.
* /scripts/deploy -> This folder is used to maintain Cloud Foundry deployment manifest files.
* /src/main/java -> This folder is used to maintain the main java source code.
* /src/main/resources -> This folder is used to maintain the bootstrap configuration of the application.
* /src/test/java -> This folder is used to maintain the java tests source code.
* /src/test/resources -> This folder is used to maintain the testing configuration of the application.


## Getting Support

In case you need any support you can write an email to [Erikson Murrugarra](mailto:erikson.murrugarrasifuentes@one.verizon.com) and [Diego Arguelles](mailto:Diego.ArguellesRojas@one.verizon.com).


## Building From source

The  E-bonding Push Notifications API uses a Maven build system. In the instructions below, mvn (Maven) is invoked from the root of the source tree.

### Prerequisites

[Maven](http://maven.apache.org/download.cgi), [Git](https://git-scm.com/downloads) and [JDK 7](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later

### Check out sources

`git clone https://onestash.verizon.com/scm/etmslabs/ebond-pushnotifications-api.git`

### Install all jars into your local Maven cache

`mvn compile`

### Compile, test and run

- In order to compile the project and generate the jar file run the following command:

    `mvn clean install`

- In order to run tests you can use the following command:

    `mvn test`

- In order to run this project locally you can use the following command:

    `mvn spring-boot:run`


This is an example on how to run this project locally:

`mvn spring-boot:run`

If you want to run directly from a Jar file you can do it as follows:

`java -jar target/ebond-pushnotifications-api-0.0.1-SNAPSHOT.jar`
