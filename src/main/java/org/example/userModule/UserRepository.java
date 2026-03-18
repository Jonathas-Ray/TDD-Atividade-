package org.example.userModule;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }
    public User findUserByEmail(String email){
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public void addUser(User user){
        users.add(user);
    }

}
