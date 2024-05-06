package com.example.Seminar_7.controller;
import com.example.Seminar_7.service.AdminService;
import com.example.Seminar_7.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;
    private final AdminService adminService;


    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/public-data")
    public String user(Model model){
        model.addAttribute("text", userService.getText());
        return "user";
    }

    @GetMapping("/private-data")
    public String admin(Model model){
        model.addAttribute("text", adminService.getText());
        return "admin";
    }


}
