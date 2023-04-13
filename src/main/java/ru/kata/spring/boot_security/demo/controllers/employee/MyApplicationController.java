package ru.kata.spring.boot_security.demo.controllers.employee;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.Application_longpass;
import ru.kata.spring.boot_security.demo.entities.ParkingZone;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.*;


@Controller
@RequestMapping("/employee/")
public class MyApplicationController {

    private final UserService userService;
    private final RoleService roleService;
    private final ParkingZoneService parkingZoneService;

    private final EmployeeService employeeService;

    private final Application_longpassService applicationLongpassService;

    public MyApplicationController(UserService userService, RoleService roleService, ParkingZoneService parkingZoneService, EmployeeService employeeService, Application_longpassService applicationLongpassService) {
        this.userService = userService;
        this.roleService = roleService;
        this.parkingZoneService = parkingZoneService;
        this.employeeService = employeeService;
        this.applicationLongpassService = applicationLongpassService;
    }

    @GetMapping(value = "/myApplication")
    public String userPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("authenticatedUser",user);
        model.addAttribute("newLongApplication",new Application_longpass());
        /*model.addAttribute("newUser",new User());
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("listRoles", roleService.listRoles());
        model.addAttribute("listParkingZones", parkingZoneService.listParkingZones());
        model.addAttribute("listEmployee", employeeService.listEmployee());
        model.addAttribute("listApplication_longpass", applicationLongpassService.listApplication_longpass());*/
        return "/employee/myApplication";
    }

    @PatchMapping("/myApplication/{id}/update")
    public String update(ParkingZone parkingZone){
        parkingZoneService.updateParkingZone(parkingZone);
        return "redirect:/employee/myApplication";
    }

    @DeleteMapping("/myApplication/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        parkingZoneService.deleteParkingZone(id);
        return "redirect:/employee/myApplication";
    }

    @PostMapping("/myApplication")
    public String createParkingZone(@ModelAttribute("parkingZone") ParkingZone parkingZone){
        parkingZoneService.saveParkingZone(parkingZone);
        return "redirect:/employee/myApplication";
    }
}

