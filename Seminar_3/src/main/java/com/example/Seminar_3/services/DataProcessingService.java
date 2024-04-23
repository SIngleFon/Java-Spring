package com.example.Seminar_3.services;

import com.example.Seminar_3.domain.User;
import com.example.Seminar_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository repository;

    public UserRepository getRepository(){
        return repository;
    }
    public void addUserToList(User user){
        repository.getUserList().add(user);
    }
    public List<User> sortUsersByAge(List<User> users) {

        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        List<User> test = new ArrayList<>();
        for(User user : users){
            if (user.getAge() == age){
                test.add(user);
            }
        }
        return test;
//        return users.stream()
//                .filter(user -> user.getAge() > age)
//                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}
