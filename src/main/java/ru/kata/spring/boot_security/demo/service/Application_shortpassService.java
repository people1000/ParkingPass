package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entities.Application_longpass;
import ru.kata.spring.boot_security.demo.entities.Application_shortpass;

import java.util.List;

public interface Application_shortpassService {
 public void saveApplication_shortpass(Application_shortpass application_shortpass);
 public List<Application_shortpass> listApplication_shortpass();
 public Application_shortpass getApplication_shortpass(Long id);
 public void updateApplication_shortpass(Application_shortpass application_shortpass);
 public void deleteApplication_shortpass(Long id);
}
