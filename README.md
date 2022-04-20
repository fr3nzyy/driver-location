You must have installed:
* java 11 
* Apache Maven
* Docker

In root folder of project type commands:
* mvn clean install
* docker build -t driver-location .
* docker-compose up --build

### Endpoints

---
PATCH
http://localhost:8081/drivers/123/locations

Body (json):

{
"latitude": 48.864193,
"longitude": 2.350498
}

---
GET
http://localhost:8080/drivers/123

Request Headers
Content-Type
application/json