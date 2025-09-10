package com.example;

/**
 * Simple User model to demonstrate Stream operations
 */
public class User {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String department;
    private double salary;
    private boolean active;
    
    // Constructor
    public User(Long id, String name, String email, int age, String department, double salary, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    
    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', age=%d, dept='%s', salary=%.2f, active=%s}", 
                           id, name, age, department, salary, active);
    }
}