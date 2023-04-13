package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entities.Employee;

import java.util.List;

public interface EmployeeService {
 public void saveEmployee(Employee employee);
 public List<Employee> listEmployee();
 public Employee getEmployee(Long id);
 public void updateEmployee(Employee employee);
 public void deleteEmployee(Long id);
}
