package ru.kata.spring.boot_security.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.Employee;
import ru.kata.spring.boot_security.demo.entities.ParkingZone;
import ru.kata.spring.boot_security.demo.repository.EmployeeRepository;
import ru.kata.spring.boot_security.demo.repository.ParkingZoneRepository;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ParkingZoneRepository parkingZoneRepository;

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ParkingZoneRepository parkingZoneRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.parkingZoneRepository = parkingZoneRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        /*employee.setAddress(employee.getAddress());
        employee.setNameParkingZone(employee.getNameParkingZone());
        employee.setCapacity(employee.getCapacity());
        employee.setEntry_type(employee.getEntry_type());*/
        employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee getEmployee(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        /*employee.setAddress(employee.getAddress());
        employee.setNameParkingZone(employee.getNameParkingZone());
        employee.setCapacity(employee.getCapacity());
        employee.setEntry_type(employee.getEntry_type());*/
        employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}