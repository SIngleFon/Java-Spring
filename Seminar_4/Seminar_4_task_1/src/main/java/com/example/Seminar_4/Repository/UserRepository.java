package com.example.Seminar_4.Repository;

import com.example.Seminar_4.Model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class UserRepository {
    List<User> userList = new ArrayList<>();

    public void userAdd(User user){
        userList.add(user);
    }
}
