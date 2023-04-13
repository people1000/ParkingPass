package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.entities.ParkingZone;
import ru.kata.spring.boot_security.demo.entities.Role;

public interface ParkingZoneRepository extends JpaRepository<ParkingZone, Long> {

}