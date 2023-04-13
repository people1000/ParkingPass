package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entities.Application_longpass;

import java.util.List;

public interface Application_longpassService {
 public void saveApplication_longpass(Application_longpass application_longpass);
 public List<Application_longpass> listApplication_longpass();
 public Application_longpass getApplication_longpass(Long id);
 public void updateApplication_longpass(Application_longpass application_longpass);
 public void deleteApplication_longpass(Long id);
}
