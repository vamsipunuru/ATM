# Getting Started

### Reference Documentation

**Run the application using maven 
**
mvn clean install spring-boot:run

**Run application with docker from root folder
**

docker-compose build

docker-compose up

Application Launch Url

http://localhost:8080/swagger-ui.html

Implemented API /api/v1/withdraw

Body should provide with the below given details
{
  "accountNumber": 123456789,
  "amount": 575,
  "pin": 1234
}


**Database tables we can see in the below url 
**

http://localhost:8080/h2-console/

Application DB connection details in application.properties

JDBC Url :jdbc:h2:mem:testdb

Account table initialized with account details

ATM table initialized with atm amount(1500)

Currency table initialized with default available count of amount and currency.







