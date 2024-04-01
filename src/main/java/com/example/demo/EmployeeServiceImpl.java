package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // In-memory storage for simplicity. Replace with database access.
    private Map<Long, Employee> employees = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employees.get(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Long id = idCounter++;
        employee.setId(id);
        employees.put(id, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if (employees.containsKey(id)) {
            employee.setId(id);
            employees.put(id, employee);
            return employee;
        } else {
            return null;
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employees.remove(id);
    }
}