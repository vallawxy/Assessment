
## Requirements
* Java 17
* Install any Java IDE
* Apache Maven
* PostgreSQL

## Development Setup
**1. Clone the repo**

`git clone https://github.com/vallawxy/Assessment`

**2. Create PostgreSQL database**

`create database ToppanAssessment`


**3. Change PostgreSQL username and password as per your installation**
* open `src/main/resources/application.properties`
* change `spring.datasource.username` and `spring.datasource.password` as per your postgreSQL installation

**4. Build and run**

* run `mvn package`to build jar executable.
* run `java -jar target/Assessment-0.0.1-SNAPSHOT.jar`
Alternatively,
* run `mvn spring-boot:run`

> By default it will run on 8080 port : http://localhost:8080.

> Postman : https://documenter.getpostman.com/view/18049837/2s7YfGDczC