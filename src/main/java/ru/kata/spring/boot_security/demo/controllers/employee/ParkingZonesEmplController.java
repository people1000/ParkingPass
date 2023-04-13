package ru.kata.spring.boot_security.demo.controllers.employee;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.*;


@Controller
@RequestMapping("/employee/")
public class ParkingZonesEmplController {
    private final ParkingZoneService parkingZoneService;

    public ParkingZonesEmplController(ParkingZoneService parkingZoneService) {
        this.parkingZoneService = parkingZoneService;
    }

    @GetMapping(value = "/parkingZonesEmpl")
    public String userPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("authenticatedUser",user);
        model.addAttribute("listParkingZones", parkingZoneService.listParkingZones());
        return "/employee/parkingZonesEmpl";
    }
}

