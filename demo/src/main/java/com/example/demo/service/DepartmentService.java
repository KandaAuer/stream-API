package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int departmentId);
    Employee findEmployeeWithMinSalary(int departmentId);
    List<Employee> findAllEmployeesByDepartment(int departmentId);
    Map<Integer, List<Employee>> findAllEmployeesGroupedByDepartments();
}
