package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.ParkingZone;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.repository.ParkingZoneRepository;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.List;

@Service
public class ParkingZoneServiceImpl implements ParkingZoneService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ParkingZoneRepository parkingZoneRepository;

    public ParkingZoneServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ParkingZoneRepository parkingZoneRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.parkingZoneRepository = parkingZoneRepository;
    }

    @Transactional
    public void saveParkingZone(ParkingZone parkingZone) {
        parkingZone.setAddress(parkingZone.getAddress());
        parkingZone.setNameParkingZone(parkingZone.getNameParkingZone());
        parkingZone.setCapacity(parkingZone.getCapacity());
        parkingZone.setEntry_type(parkingZone.getEntry_type());
        parkingZoneRepository.save(parkingZone);
    }

    @Transactional(readOnly = true)
    public List<ParkingZone> listParkingZones() {
        return parkingZoneRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ParkingZone getParkingZone(Long id) {
        return parkingZoneRepository.getById(id);
    }

    @Override
    @Transactional
    public void updateParkingZone(ParkingZone parkingZone) {
        parkingZone.setAddress(parkingZone.getAddress());
        parkingZone.setNameParkingZone(parkingZone.getNameParkingZone());
        parkingZone.setCapacity(parkingZone.getCapacity());
        parkingZone.setEntry_type(parkingZone.getEntry_type());
        parkingZoneRepository.save(parkingZone);
    }

    @Transactional
    public void deleteParkingZone(Long id) {
        parkingZoneRepository.deleteById(id);
    }
}