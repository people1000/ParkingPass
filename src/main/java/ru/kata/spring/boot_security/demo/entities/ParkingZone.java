package ru.kata.spring.boot_security.demo.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parking_zones")
public class ParkingZone implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_zone")
    private String name_zone;

    @Column(name = "address")
    private String address;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "entry_type")
    private String entry_type;

    @OneToMany (targetEntity = Application_shortpass.class, mappedBy = "parkingZone", fetch = FetchType.LAZY)
    private List applications_shortpass;

    @OneToMany (targetEntity = Application_longpass.class, mappedBy = "parkingZone", fetch = FetchType.LAZY)
    private List applications_longpass;

    public List getApplications_longpass() {
        return applications_longpass;
    }

    public void setApplications_longpass(List applications_longpass) {
        this.applications_longpass = applications_longpass;
    }

    public ParkingZone() {
    }

    public ParkingZone(String nameParkingZone) {
        this.name_zone = nameParkingZone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_zone() {
        return name_zone;
    }

    public void setName_zone(String name_zone) {
        this.name_zone = name_zone;
    }

    public List getApplications_shortpass() {
        return applications_shortpass;
    }

    public void setApplications_shortpass(List applications_shortpass) {
        this.applications_shortpass = applications_shortpass;
    }

    public String getNameParkingZone() {
        return name_zone;
    }

    public void setNameParkingZone(String nameParkingZone) {
        this.name_zone = nameParkingZone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEntry_type() {
        return entry_type;
    }

    public void setEntry_type(String entryType) {
        this.entry_type = entryType;
    }

    @Override
    public String getAuthority() {
        return getNameParkingZone();
    }
    @Override
    public String toString() {
        return this.name_zone;
    }

}