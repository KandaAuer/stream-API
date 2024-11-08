package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public ResponseEntity<Employee> getEmployeeWithMaxSalary(@RequestParam int departmentId) {
        try {
            Employee employee = departmentService.findEmployeeWithMaxSalary(departmentId);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/min-salary")
    public ResponseEntity<Employee> getEmployeeWithMinSalary(@RequestParam int departmentId) {
        try {
            Employee employee = departmentService.findEmployeeWithMinSalary(departmentId);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployeesByDepartment(@RequestParam int departmentId) {
        List<Employee> employees = departmentService.findAllEmployeesByDepartment(departmentId);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/all-grouped")
    public ResponseEntity<Map<Integer, List<Employee>>> getAllEmployeesGroupedByDepartment() {
        Map<Integer, List<Employee>> employeesGrouped = departmentService.findAllEmployeesGroupedByDepartments();
        return new ResponseEntity<>(employeesGrouped, HttpStatus.OK);
    }
}
