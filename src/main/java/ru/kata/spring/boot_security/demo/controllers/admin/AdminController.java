package ru.kata.spring.boot_security.demo.controllers.admin;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.*;


@Controller
@RequestMapping("/admin/")

public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController (UserService userService, RoleService roleService) {

        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String allUsers(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("authenticatedUser",user);
        model.addAttribute("newUser",new User());
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("listRoles", roleService.listRoles());
        return "/admin/admin";
    }

    @PostMapping("/admin")
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/admin/admin";
    }

    @PatchMapping("/admin/{id}/update")
    public String update(User user){
        userService.updateUser(user);
        return "redirect:/admin/admin";
    }

    @DeleteMapping("/admin/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return "redirect:/admin/admin";
    }
}