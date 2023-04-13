
package ru.kata.spring.boot_security.demo.controllers.employee;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

@Controller
public class UserController {
    private final UserServiceImpl userServiceImpl;
    private final RoleServiceImpl roleServiceImpl;
    public UserController(UserServiceImpl userServiceImpl, RoleServiceImpl roleServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.roleServiceImpl = roleServiceImpl;
    }

    @GetMapping(value = "/user")
    public String userPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("listRoles", roleServiceImpl.listRoles());

        return "user";
    }

}