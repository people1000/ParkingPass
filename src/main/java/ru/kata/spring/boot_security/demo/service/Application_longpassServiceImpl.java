package ru.kata.spring.boot_security.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.Application_longpass;
import ru.kata.spring.boot_security.demo.entities.Employee;
import ru.kata.spring.boot_security.demo.repository.*;

import java.util.List;

@Service
public class Application_longpassServiceImpl implements Application_longpassService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ParkingZoneRepository parkingZoneRepository;

    private final EmployeeRepository employeeRepository;

    private final Application_longpassRepository applicationLongpassRepository;

    public Application_longpassServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ParkingZoneRepository parkingZoneRepository, EmployeeRepository employeeRepository, Application_longpassRepository applicationLongpassRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.parkingZoneRepository = parkingZoneRepository;
        this.employeeRepository = employeeRepository;
        this.applicationLongpassRepository = applicationLongpassRepository;
    }

    @Transactional
    public void saveApplication_longpass(Application_longpass application_longpass) {
        /*employee.setAddress(employee.getAddress());
        employee.setNameParkingZone(employee.getNameParkingZone());
        employee.setCapacity(employee.getCapacity());
        employee.setEntry_type(employee.getEntry_type());*/
        applicationLongpassRepository.save(application_longpass);
    }

    @Transactional(readOnly = true)
    public List<Application_longpass> listApplication_longpass() {
        return applicationLongpassRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Application_longpass getApplication_longpass(Long id) {
        return applicationLongpassRepository.getById(id);
    }

    @Override
    @Transactional
    public void updateApplication_longpass(Application_longpass application_longpass) {
        /*employee.setAddress(employee.getAddress());
        employee.setNameParkingZone(employee.getNameParkingZone());
        employee.setCapacity(employee.getCapacity());
        employee.setEntry_type(employee.getEntry_type());*/
        applicationLongpassRepository.save(application_longpass);
    }

    @Transactional
    public void deleteApplication_longpass(Long id) {applicationLongpassRepository.deleteById(id);
    }
}