package com.example;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class demonstrating Java Streams for data processing
 * This shows filtering, mapping, and reducing operations
 */
@Service
public class UserService {
    
    private List<User> users;
    
    public UserService() {
        // Initialize sample data
        this.users = Arrays.asList(
            new User(1L, "Alice Johnson", "alice@company.com", 28, "Engineering", 75000.0, true),
            new User(2L, "Bob Smith", "bob@company.com", 35, "Marketing", 65000.0, true),
            new User(3L, "Carol Davis", "carol@company.com", 42, "Engineering", 95000.0, false),
            new User(4L, "David Wilson", "david@company.com", 29, "Sales", 55000.0, true),
            new User(5L, "Eva Brown", "eva@company.com", 31, "Engineering", 80000.0, true),
            new User(6L, "Frank Miller", "frank@company.com", 45, "Marketing", 70000.0, false),
            new User(7L, "Grace Lee", "grace@company.com", 26, "Sales", 50000.0, true),
            new User(8L, "Henry Taylor", "henry@company.com", 38, "Engineering", 90000.0, true)
        );
    }
    
    /**
     * FILTERING: Get only active users
     * filter() keeps elements that match the condition
     */
    public List<User> getActiveUsers() {
        return users.stream()
                   .filter(User::isActive)  // Method reference - same as: user -> user.isActive()
                   .collect(Collectors.toList());
    }
    
    /**
     * FILTERING with multiple conditions: Active users in Engineering
     */
    public List<User> getActiveEngineers() {
        return users.stream()
                   .filter(user -> user.isActive())           // First condition
                   .filter(user -> "Engineering".equals(user.getDepartment())) // Second condition
                   .collect(Collectors.toList());
    }
    
    /**
     * MAPPING: Transform User objects to just their names
     * map() transforms each element to something else
     */
    public List<String> getUserNames() {
        return users.stream()
                   .map(User::getName)  // Extract name from each User
                   .collect(Collectors.toList());
    }
    
    /**
     * MAPPING: Transform users to email addresses (uppercase)
     */
    public List<String> getUppercaseEmails() {
        return users.stream()
                   .map(User::getEmail)           // Get email
                   .map(String::toUpperCase)      // Transform to uppercase
                   .collect(Collectors.toList());
    }
    
    /**
     * REDUCING: Calculate total salary of all active users
     * reduce() combines all elements into a single result
     */
    public double getTotalActiveSalary() {
        return users.stream()
                   .filter(User::isActive)
                   .mapToDouble(User::getSalary)  // Convert to DoubleStream
                   .sum();                        // Built-in reduction operation
    }
    
    /**
     * REDUCING: Find the highest salary
     */
    public OptionalDouble getHighestSalary() {
        return users.stream()
                   .mapToDouble(User::getSalary)
                   .max();  // Returns OptionalDouble in case list is empty
    }
    
    public OptionalDouble getLowestSalary() {
        return users.stream()
                    .mapToDouble(User:: getSalary)
                    .min(); // Returns Optional Double in case list is empty
    }
    
    /**
     * COMPLEX OPERATION: Group users by department and count them
     * collect() with Collectors.groupingBy() for advanced data manipulation
     */
    public Map<String, Long> getUserCountByDepartment() {
        return users.stream()
                   .collect(Collectors.groupingBy(
                       User::getDepartment,           // Group by department
                       Collectors.counting()          // Count users in each group
                   ));
    }
    
    /**
     * COMPLEX OPERATION: Get average salary by department for active users only
     */
    public Map<String, Double> getAverageSalaryByDepartment() {
        return users.stream()
                   .filter(User::isActive)
                   .collect(Collectors.groupingBy(
                       User::getDepartment,
                       Collectors.averagingDouble(User::getSalary)
                   ));
    }
    
    /**
     * CHAINING OPERATIONS: Get names of top 3 highest paid active users
     */
    public List<String> getTop3HighestPaidActiveUsers() {
        return users.stream()
                   .filter(User::isActive)                    // Filter active users
                   .sorted((u1, u2) -> Double.compare(u2.getSalary(), u1.getSalary())) // Sort by salary desc
                   .limit(3)                                  // Take only first 3
                   .map(User::getName)                        // Get their names
                   .collect(Collectors.toList());
    }
    
    /**
     * FIND OPERATIONS: Find first user with salary > 80000
     */
    public Optional<User> getFirstHighEarner() {
        return users.stream()
                   .filter(user -> user.getSalary() > 80000)
                   .findFirst();  // Returns Optional<User>
    }
    
    /**
     * CHECK OPERATIONS: Check if any user is over 40
     */
    public boolean hasUserOver40() {
        return users.stream()
                   .anyMatch(user -> user.getAge() > 40);
    }
    
    /**
     * Get all users (for demonstration)
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}