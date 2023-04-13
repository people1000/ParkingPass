package ru.kata.spring.boot_security.demo.controllers.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.ParkingZone;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.*;


@Controller
@RequestMapping("/admin/")
public class ApplicationController {

    private final UserService userService;
    private final RoleService roleService;
    private final ParkingZoneService parkingZoneService;

    private final EmployeeService employeeService;

    private final Application_longpassService applicationLongpassService;

    private final Application_shortpassService applicationShortpassService;

    public ApplicationController(UserService userService, RoleService roleService, ParkingZoneService parkingZoneService, EmployeeService employeeService, Application_longpassService applicationLongpassService, Application_shortpassService applicationShortpassService) {
        this.userService = userService;
        this.roleService = roleService;
        this.parkingZoneService = parkingZoneService;
        this.employeeService = employeeService;
        this.applicationLongpassService = applicationLongpassService;
        this.applicationShortpassService = applicationShortpassService;
    }

    @GetMapping(value = "/applications")
    public String userPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("authenticatedUser",user);
        model.addAttribute("listApplication_shortpass", applicationShortpassService.listApplication_shortpass());
        model.addAttribute("listApplication_longpass", applicationLongpassService.listApplication_longpass());
        return "/admin/applications";
    }

    @PatchMapping("/applications/{id}/update")
    public String update(ParkingZone parkingZone){
        parkingZoneService.updateParkingZone(parkingZone);
        return "redirect:/admin/applications";
    }

    @DeleteMapping("/applications/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        parkingZoneService.deleteParkingZone(id);
        return "redirect:/admin/applications";
    }

    @PostMapping("/applications")
    public String createParkingZone(@ModelAttribute("parkingZone") ParkingZone parkingZone){
        parkingZoneService.saveParkingZone(parkingZone);
        return "redirect:/admin/applications";
    }
}

