package com.example.Seminar_3.services;

import com.example.Seminar_3.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user){
        System.out.printf("A new user created: "+user.getName()+"\n");
    }

    public String sendNotification(User user) {
        return "A new user has been created: " + user.getName() + "\n";
    }
}
