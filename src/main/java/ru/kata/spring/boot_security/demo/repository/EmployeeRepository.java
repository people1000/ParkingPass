package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}