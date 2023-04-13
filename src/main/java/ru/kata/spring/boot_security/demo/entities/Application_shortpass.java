package ru.kata.spring.boot_security.demo.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application_shortpass")
public class Application_shortpass implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "number_avto")
    private String number_avto;
    @ManyToOne (targetEntity = ParkingZone.class, fetch = FetchType.LAZY)
    @JoinColumn (name = "parking_zone_id")
    private ParkingZone parkingZone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNumber_avto() {
        return number_avto;
    }

    public void setNumber_avto(String number_avto) {
        this.number_avto = number_avto;
    }

    public ParkingZone getParkingZone() {
        return parkingZone;
    }

    public void setParkingZone(ParkingZone parkingZone) {
        this.parkingZone = parkingZone;
    }

    public LocalDateTime getDate_start() {
        return date_start;
    }

    public void setDate_start(LocalDateTime date_start) {
        this.date_start = date_start;
    }

    public LocalDateTime getDate_end() {
        return date_end;
    }

    public void setDate_end(LocalDateTime date_end) {
        this.date_end = date_end;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    @Column(name = "date_start")
    private LocalDateTime date_start;
    @Column(name = "date_end")
    private LocalDateTime date_end;
    @Column(name = "status")
    private int status;
    @Column(name = "document")
    private String document;
    @ManyToOne (targetEntity = Employee.class, fetch = FetchType.LAZY)
    @JoinColumn (name = "employee_id")
    private Employee employee;

    public Application_shortpass() {
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
