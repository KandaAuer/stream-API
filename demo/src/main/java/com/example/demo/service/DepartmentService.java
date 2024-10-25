package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employeeService.getAllEmployeesGroupedByDepartment();
    }

    public Set<Employee> getEmployeesByDepartment(int department) {
        return employeeService.getEmployeesByDepartment(department);
    }

    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeService.getEmployeeWithMaxSalary(department);
    }

    public Employee getEmployeeWithMinSalary(int department) {
        return employeeService.getEmployeeWithMinSalary(department);
    }
}
