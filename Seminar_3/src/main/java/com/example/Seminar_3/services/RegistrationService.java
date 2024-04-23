package com.example.Seminar_3.services;

import com.example.Seminar_3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;

    public String processRegistration(String name, int age, String email){
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        return notificationService.sendNotification(newUser);
    }

    public DataProcessingService getDataProcessingService(){
        return dataProcessingService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public UserService getUserService() {
        return userService;
    }
}
