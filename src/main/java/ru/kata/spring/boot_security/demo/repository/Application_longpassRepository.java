package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.entities.Application_longpass;

public interface Application_longpassRepository extends JpaRepository<Application_longpass, Long> {

}