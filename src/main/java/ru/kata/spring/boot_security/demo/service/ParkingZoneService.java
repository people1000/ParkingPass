package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entities.ParkingZone;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface ParkingZoneService {
 public void saveParkingZone(ParkingZone parkingZone);
 public List<ParkingZone> listParkingZones();
 public ParkingZone getParkingZone(Long id);
 public void updateParkingZone(ParkingZone parkingZone);
 public void deleteParkingZone(Long id);
}
