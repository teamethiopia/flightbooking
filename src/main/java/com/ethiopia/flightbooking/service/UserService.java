package com.ethiopia.flightbooking.service;


import com.ethiopia.flightbooking.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService
{
    Page<User> getAllUsersPaged(int pageNo);
    List<User> getAllUsersList();
    User getUserById(Integer id);
    void deleteUserById(Integer id);
    User saveUser(User user);

}
