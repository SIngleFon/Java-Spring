package com.example.Seminar_3.controllers;

import com.example.Seminar_3.domain.User;
import com.example.Seminar_3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/users")
public class UserController {
    static int i = 0;
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList(){
        return service.getDataProcessingService().getRepository().getUserList();
    }
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.getDataProcessingService().getRepository().getUserList().add(user);
        service.getNotificationService().notifyUser(user);
        return service.getNotificationService().sendNotification(user);
    }
    //Usage: localhost:8080/users/param?name="name"&age="age"&email="email" - only postman
    @PostMapping("/param")
    @ResponseBody
    public String userAddFromParam(
            @RequestParam("name") String name
            , @RequestParam("age") int age
            , @RequestParam("email") String email) {
        return service.processRegistration(name, age, email);
    }

    @PostMapping("/test")
    public String userAddTest(){
        List<User> list = new ArrayList<>(){{
            add(new User());
            add(new User());
            add(new User());
        }};;

        Random r = new Random();
        for (User user : list){
            user.setName("Example_"+i);
            user.setAge(r.nextInt(20, 31));
            user.setEmail("Example_main_"+i+"@mail.ru");
            i++;
            service.getDataProcessingService().getRepository().getUserList().add(user);
            service.getNotificationService().notifyUser(user);
            service.getNotificationService().sendNotification(user);
        }
        return "Added users for test!";
    }
}
