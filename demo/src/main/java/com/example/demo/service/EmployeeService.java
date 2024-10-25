package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Set<Employee> employees = new HashSet<>();

    public EmployeeService() {
        employees.add(new Employee("Канда", "Ауэр", 50000, 1));
        employees.add(new Employee("Юлия", "Тарасюк", 55000, 1));
        employees.add(new Employee("Илья", "Яровой", 60000, 2));
        employees.add(new Employee("Наталья", "Громова", 45000, 2));
        employees.add(new Employee("Алексей", "Попов", 70000, 3));
    }

    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        employees.add(employee);
        return employee;
    }

    public Set<Employee> getAllEmployees() {
        return new HashSet<>(employees);
    }

    public Set<Employee> getEmployeesByDepartment(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toSet());
    }

    public Employee getEmployeeWithMaxSalary(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalary(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
