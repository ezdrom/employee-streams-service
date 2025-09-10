package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * REST Controller to demonstrate Stream operations via HTTP endpoints
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/active")
    public List<User> getActiveUsers() {
        return userService.getActiveUsers();
    }
    
    @GetMapping("/engineers/active")
    public List<User> getActiveEngineers() {
        return userService.getActiveEngineers();
    }
    
    @GetMapping("/names")
    public List<String> getUserNames() {
        return userService.getUserNames();
    }
    
    @GetMapping("/emails/uppercase")
    public List<String> getUppercaseEmails() {
        return userService.getUppercaseEmails();
    }
    
    @GetMapping("/salary/total-active")
    public double getTotalActiveSalary() {
        return userService.getTotalActiveSalary();
    }
    
    @GetMapping("/salary/highest")
    public String getHighestSalary() {
        OptionalDouble highestSalary = userService.getHighestSalary();
        if (highestSalary.isPresent()) {
            return "Highest salary: $" + highestSalary.getAsDouble();
        } else {
            return "No users found";
        }
    }

    @GetMapping("/salary/lowest")
    public String getLowestSalary() {
        OptionalDouble LowestSalary = userService.getLowestSalary();
        if (LowestSalary.isPresent()) {
            return "Lowest salary: $" + LowestSalary.getAsDouble();
        } else {
            return "No users found";
        }
    }
    
    @GetMapping("/stats/count-by-department")
    public Map<String, Long> getUserCountByDepartment() {
        return userService.getUserCountByDepartment();
    }
    
    @GetMapping("/stats/average-salary-by-department")
    public Map<String, Double> getAverageSalaryByDepartment() {
        return userService.getAverageSalaryByDepartment();
    }
    
    @GetMapping("/top3-earners")
    public List<String> getTop3HighestPaidActiveUsers() {
        return userService.getTop3HighestPaidActiveUsers();
    }
    
    @GetMapping("/first-high-earner")
    public String getFirstHighEarner() {
        Optional<User> user = userService.getFirstHighEarner();
        return user.map(u -> "First high earner: " + u.getName())
                  .orElse("No high earner found");
    }
    
    @GetMapping("/has-user-over-40")
    public boolean hasUserOver40() {
        return userService.hasUserOver40();
    }
}