package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.entities.Application_longpass;
import ru.kata.spring.boot_security.demo.entities.Application_shortpass;

public interface Application_shortpassRepository extends JpaRepository<Application_shortpass, Long> {

}