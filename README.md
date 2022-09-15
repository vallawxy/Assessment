
## Requirements
* Java 8
* Install any Java IDE
* Apache Maven

## Development Setup
**1. Clone the application**

`code`

**2. Create Postgres database**

`create database ToppanAssessment`


**3. Change Postgres username and password as per your installation**
* open `src/main/resources/application.properties`
* change `spring.datasource.username` and `spring.datasource.password` as per your postgres installation

**4. Build and run**

* run `mvn package`to build jar executable.
* run `java -jar target/Assessment-0.0.1-SNAPSHOT.jar`
Alternatively,
* run `mvn spring-boot:run`

By default the application it will run on 8080 port http://localhost:8080.



