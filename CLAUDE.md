# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Cloud Alibaba 2023 demo project integrating Apache SkyWalking for application performance monitoring (APM). The project demonstrates distributed tracing and monitoring capabilities in a microservices architecture.

## Build and Run

### Build the project
```bash
mvn clean install
```

### Build specific module
```bash
mvn clean install -pl skywalking/tlmall-user-skywalking-demo
```

### Run the application
```bash
cd skywalking/tlmall-user-skywalking-demo
mvn spring-boot:run
```

The application runs on port 8000 by default.

### Run tests
```bash
mvn test
```

Run tests for specific module:
```bash
mvn test -pl skywalking/tlmall-user-skywalking-demo
```

## Technology Stack

- **Java**: 21
- **Spring Boot**: 3.2.4
- **Spring Cloud**: 2023.0.1
- **Spring Cloud Alibaba**: 2023.0.1.0
- **MyBatis**: 3.0.3
- **MySQL Connector**: 8.0.17
- **Apache SkyWalking Toolkit**: 9.3.0 (trace and logback integration)
- **Lombok**: For reducing boilerplate code

## Architecture

This is a multi-module Maven project with a parent POM managing dependencies and versions.

### Module Structure

- **skywalking/tlmall-user-skywalking-demo**: User service demo with SkyWalking integration
  - Package: `org.skywalkingdemo.usersvc`
  - Controllers: REST endpoints for user operations
  - Services: Business logic layer
  - DAO: MyBatis mappers for database access
  - Entities: Data models

### SkyWalking Integration

The project uses SkyWalking toolkit for:
- **Distributed Tracing**: Automatic trace propagation across service calls
- **TraceContext**: Programmatic access to trace IDs and custom correlation data
- **Logback Integration**: Automatic trace ID injection in logs for correlation

Example usage in `UserController.java`:
```java
String traceId = TraceContext.traceId();
TraceContext.putCorrelation("name", "value");
```

## Database Configuration

The application expects a MySQL database named `test` running on localhost:3306 with credentials `root/root`. Configure in `application.yml`.

## Common Patterns

- MyBatis mappers are scanned via `@MapperScan("org.skywalkingdemo.usersvc.dao")`
- REST controllers follow Spring `@RestController` pattern with `@RequestMapping`
- Services use standard Spring `@Service` annotation with interface-based design
- Logging uses SLF4J with Lombok's `@Slf4j` annotation