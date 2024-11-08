package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl() {
        employees.add(new Employee("Канда Ауэр", 50000, 1));
        employees.add(new Employee("Юлия Тарасюк", 55000, 2));
        employees.add(new Employee("Илья Яровой", 60000, 1));
        employees.add(new Employee("Наталья Громова", 45000, 2));
        employees.add(new Employee("Алексей Попов", 70000, 3));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
