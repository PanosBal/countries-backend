# Countries Backend

##  Tech Stack
- **Java 8**
- **Spring Boot 2.7**
- **MyBatis**
- **MariaDB**
- **Lombok**
- **JUnit + Mockito**

## Setup
### Prerequisites
Before running the backend, make sure you have:

- Java 8 JDK installed and `JAVA_HOME` set.
- Apache Maven 3.6+ installed.
- MariaDB installed and running locally (default port 3306).
- A database named `nation` created, populated with the provided `nation.sql` file and running.

## Running Backend Locally

### Clone the Repository

```bash
git clone https://github.com/PanosBal/countries-backend.git
cd YOUR_PATH/countries-backend
```
### Create Database
```bash
brew services start mariadb
mysql -u root -p
CREATE DATABASE nation;
USE nation;
SOURCE YOUR_PATH/nation.sql;
```

### Configure Connection
```bash
Edit the database password in the file: src/main/resources/application.properties
spring.datasource.password=your_password
```

### Build and run the Application
```bash
mvn clean install
mvn spring-boot:run
```
## Endpoints

- **GET** `/api/countries` – List all countries
- **GET** `/api/countries/{id}/languages` – List languages for a country
- **GET** `/api/stats/max-gdp-ratio` – Countries with maximum GDP/population ratio
- **GET** `/api/stats/country-stats` – Countries Stats with filters and pagination
- **GET** `/api/regions` – List all regions
- **GET** `/api/stats/country-stats?regionId={regionId}&yearFrom={yearFrom}&yearTo={yearTo}&page={page}&size={size}` – Countries Stats with filters and pagination

You can also find a Postman collection at: 
`countries-backend/countries_case_study.postman_collection.json`

## Tests

Run JUnit tests with the following command:

```bash
mvn test
```