# Java Streams Demo Microservice

A simple Spring Boot microservice demonstrating Java Streams for data processing, filtering, mapping, and reducing operations.

## What You'll Learn

This demo covers:
- **Filtering**: Using `filter()` to select specific elements
- **Mapping**: Using `map()` to transform data
- **Reducing**: Using `reduce()`, `sum()`, `max()` to aggregate data
- **Collecting**: Using `collect()` for complex data manipulations
- **Chaining**: Combining multiple stream operations

## Running the Application

```bash
# Compile and run
mvn spring-boot:run

# Or build and run the JAR
mvn clean package
java -jar target/streams-demo-1.0.0.jar
```

## API Endpoints

| Endpoint | Description | Stream Operations Used |
|----------|-------------|----------------------|
| `/api/users/all` | Get all users | Basic data retrieval |
| `/api/users/active` | Get only active users | `filter()` |
| `/api/users/engineers/active` | Get active engineers | `filter()` with multiple conditions |
| `/api/users/names` | Get user names only | `map()` |
| `/api/users/emails/uppercase` | Get uppercase emails | `map()` chaining |
| `/api/users/salary/total-active` | Total salary of active users | `filter()` + `mapToDouble()` + `sum()` |
| `/api/users/salary/highest` | Highest salary | `mapToDouble()` + `max()` |
| `/api/users/stats/count-by-department` | Count users by department | `collect()` + `groupingBy()` |
| `/api/users/stats/average-salary-by-department` | Average salary by dept | `collect()` + `groupingBy()` + `averagingDouble()` |
| `/api/users/top3-earners` | Top 3 highest paid active users | `filter()` + `sorted()` + `limit()` + `map()` |
| `/api/users/first-high-earner` | First user earning >$80k | `filter()` + `findFirst()` |
| `/api/users/has-user-over-40` | Check if any user is over 40 | `anyMatch()` |

## Example Usage

```bash
curl http://localhost:8080/api/users/active
curl http://localhost:8080/api/users/top3-earners
curl http://localhost:8080/api/users/stats/count-by-department
```