package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class UserAccessor {

    public List<User> getUsers(List<User> users, int page, int usersPerPage) {

        List<User> response = new ArrayList<>();
        for (int i = (page - 1) * usersPerPage; i < users.size(); i++) {
            response.add(users.get(i));
            if(response.size() == usersPerPage)
                break;
        }

        return response;
    }
}
