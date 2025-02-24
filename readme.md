# Employee CRUD Application - api-crud.jar

This is a backend application for managing employee data built with **Spring Boot (Java)**. This project focuses solely on backend functionality, providing CRUD operations for employee data using a MySQL database.

---

## Technologies Used

- **Backend:**

  - **Java:** 17.0.14 (2025-01-21 LTS)
  - **Spring Boot:** 3.4.3 (Managed with Maven)
  - **Database:** MySQL

- **Build Tools & Dependencies:**
  - **Maven:** for dependency management and build process
  - **MySQL Connector:** for database connectivity
  - **Lombok, Spring Data JPA, and other Spring Boot starters**

---

## Project Setup

### Backend Setup

The backend project is managed with Maven. Below is an excerpt from the `pom.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.4.3</version>
    <relativePath/>
  </parent>
  <groupId>fulstack.springboot</groupId>
  <artifactId>api-crud.jar</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>api-crud.jar</name>
  <description>Employee CRUD backend application for managing employee data.</description>
  <licenses>
    <license>
      MIT License
    </license>
  </licenses>
  <developers>
    <developer>
      <name>Jerypatut</name>
    </developer>
  </developers>
  <properties>
    <java.version>17</java.version>
  </properties>
  <dependencies>
    <!-- Spring Boot Starter for JPA -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <!-- Spring Boot Starter for Web -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- MySQL Connector -->
    <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
      <scope>runtime</scope>
    </dependency>
    <!-- Lombok (optional) -->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
    </dependency>
    <!-- Spring Boot Starter Test -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <!-- Maven Compiler Plugin -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
          <annotationProcessorPaths>
            <path>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
            </path>
          </annotationProcessorPaths>
        </configuration>
      </plugin>
      <!-- Spring Boot Maven Plugin -->
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
          <excludes>
            <exclude>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
            </exclude>
          </excludes>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```
Database Configuration
Configure your MySQL database in the application.properties file:

properties
Salin
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/api_crud?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Make sure to replace your_mysql_username and your_mysql_password with your actual MySQL credentials. Also, create a database named api_crud (or modify the URL accordingly).

Building and Running the Application
To build and run the Spring Boot application, use the following commands:

bash
Salin
Edit
# Build the application
mvn clean install

# Run the application
mvn spring-boot:run
Screenshots
Below are screenshots of the application:

Add Data Page (spring12.png):
This screenshot shows the page used to add new employee data.


Homepage (springboot.png):
This screenshot displays the homepage of the Spring Boot application.


License
This project is licensed under the MIT License.

Developed by [jerypatut].

