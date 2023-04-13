package ru.kata.spring.boot_security.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.Application_shortpass;
import ru.kata.spring.boot_security.demo.repository.*;

import java.util.List;

@Service
public class Application_shortpassServiceImpl implements Application_shortpassService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ParkingZoneRepository parkingZoneRepository;

    private final EmployeeRepository employeeRepository;

    private final Application_longpassRepository applicationLongpassRepository;

    private final Application_shortpassRepository applicationShortpassRepository;

    public Application_shortpassServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ParkingZoneRepository parkingZoneRepository, EmployeeRepository employeeRepository, Application_longpassRepository applicationLongpassRepository, Application_shortpassRepository applicationShortpassRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.parkingZoneRepository = parkingZoneRepository;
        this.employeeRepository = employeeRepository;
        this.applicationLongpassRepository = applicationLongpassRepository;
        this.applicationShortpassRepository = applicationShortpassRepository;
    }

    @Transactional
    public void saveApplication_shortpass(Application_shortpass application_shortpass) {
        /*employee.setAddress(employee.getAddress());
        employee.setNameParkingZone(employee.getNameParkingZone());
        employee.setCapacity(employee.getCapacity());
        employee.setEntry_type(employee.getEntry_type());*/
        applicationShortpassRepository.save(application_shortpass);
    }

    @Transactional(readOnly = true)
    public List<Application_shortpass> listApplication_shortpass() {
        return applicationShortpassRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Application_shortpass getApplication_shortpass(Long id) {
        return applicationShortpassRepository.getById(id);
    }

    @Override
    @Transactional
    public void updateApplication_shortpass(Application_shortpass application_shortpass) {
        /*employee.setAddress(employee.getAddress());
        employee.setNameParkingZone(employee.getNameParkingZone());
        employee.setCapacity(employee.getCapacity());
        employee.setEntry_type(employee.getEntry_type());*/
        applicationShortpassRepository.save(application_shortpass);
    }

    @Transactional
    public void deleteApplication_shortpass(Long id) {applicationShortpassRepository.deleteById(id);
    }
}