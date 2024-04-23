package com.example.Seminar_3.repository;

import com.example.Seminar_3.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
