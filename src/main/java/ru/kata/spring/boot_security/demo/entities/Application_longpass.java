package ru.kata.spring.boot_security.demo.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "applications_longpass")
public class Application_longpass implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne (targetEntity = Employee.class, fetch = FetchType.LAZY)
    @JoinColumn (name = "personnel_number")
    private Employee employee;

    @Column(name = "status")
    private int status;

    public ParkingZone getParkingZone() {
        return parkingZone;
    }

    public void setParkingZone(ParkingZone parkingZone) {
        this.parkingZone = parkingZone;
    }

    @ManyToOne (targetEntity = ParkingZone.class, fetch = FetchType.LAZY)
    @JoinColumn (name = "parking_zone_id")
    private ParkingZone parkingZone;

    public Application_longpass() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    @Override
    public String getAuthority() {
        return String.valueOf(status);
    }
    @Override
    public String toString() {
        return String.valueOf(this.status);
    }

}