package ru.kata.spring.boot_security.demo.controllers.employee;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.ParkingZone;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.*;


@Controller
@RequestMapping("/employee/")
public class MyPassesController {

    private final UserService userService;
    private final RoleService roleService;
    private final ParkingZoneService parkingZoneService;

    private final EmployeeService employeeService;

    private final Application_longpassService applicationLongpassService;

    public MyPassesController(UserService userService, RoleService roleService, ParkingZoneService parkingZoneService, EmployeeService employeeService, Application_longpassService applicationLongpassService) {
        this.userService = userService;
        this.roleService = roleService;
        this.parkingZoneService = parkingZoneService;
        this.employeeService = employeeService;
        this.applicationLongpassService = applicationLongpassService;
    }

    @GetMapping(value = "/myPasses")
    public String userPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("authenticatedUser",user);
        /*model.addAttribute("newUser",new User());
        model.addAttribute("newParkingZone",new ParkingZone());
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("listRoles", roleService.listRoles());
        model.addAttribute("listParkingZones", parkingZoneService.listParkingZones());
        model.addAttribute("listEmployee", employeeService.listEmployee());
        model.addAttribute("listApplication_longpass", applicationLongpassService.listApplication_longpass());*/
        return "/employee/myPasses";
    }

    @PatchMapping("/myPasses/{id}/update")
    public String update(ParkingZone parkingZone){
        parkingZoneService.updateParkingZone(parkingZone);
        return "redirect:/employee/myPasses";
    }

    @DeleteMapping("/myPasses/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        parkingZoneService.deleteParkingZone(id);
        return "redirect:/employee/myPasses";
    }

    @PostMapping("/myPasses")
    public String createParkingZone(@ModelAttribute("parkingZone") ParkingZone parkingZone){
        parkingZoneService.saveParkingZone(parkingZone);
        return "redirect:/employee/myPasses";
    }
}

