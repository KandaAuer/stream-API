package com.example.demo.model;

public class Employee {

    private String name;
    private int salary;
    private int departmentId;

    public Employee(String name, int salary, int departmentId) {
        this.name = name;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }
}
