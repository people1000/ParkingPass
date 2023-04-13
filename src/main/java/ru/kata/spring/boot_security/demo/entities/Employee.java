package ru.kata.spring.boot_security.demo.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany (targetEntity = Application_longpass.class, mappedBy = "employee", fetch = FetchType.LAZY)
    private List application_longpass;

    @OneToMany (targetEntity = Application_shortpass.class, mappedBy = "id", fetch = FetchType.LAZY)
    private List application_shortpass;

    @Column(name = "personnel_number")
    private int tabel_number;

    @Column(name = "rating")
    private int rating;


    public Employee() {
    }

    public Employee(int tabel_number) {
        this.tabel_number = tabel_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTabel_number() {
        return tabel_number;
    }

    public void setTabel_number(int tabel_number) {
        this.tabel_number = tabel_number;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List getApplication_longpass(){return application_longpass;}

    public List getApplication_shortpass() {
        return application_shortpass;
    }

    public void setApplication_shortpass(List application_shortpass) {
        this.application_shortpass = application_shortpass;
    }

    public void setApplication_longpass(List<Application_longpass> applications_longpass){
        this.application_longpass = applications_longpass;
    }

    @Override
    public String getAuthority() {
        return String.valueOf(getTabel_number());
    }
    @Override
    public String toString() {
        return String.valueOf(this.getTabel_number());
    }

}