package com.example.Seminar_4.Controller;

import com.example.Seminar_4.Model.User;
import com.example.Seminar_4.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class Contoller {
    private final UserRepository userRepository;

    @GetMapping("/users")
    public String getUser(Model model){
        model.addAttribute("users", userRepository.getUserList());
        return "users";
    }

    @PostMapping("/users")
    public String addUser(User user, Model model){
        userRepository.userAdd(user);
        model.addAttribute("users", userRepository.getUserList());
        return "users";
    }
}
