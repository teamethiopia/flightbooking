package com.ethiopia.flightbooking.service;


import com.ethiopia.flightbooking.model.User;
import org.springframework.data.domain.Page;



public interface UserService {
    Page<User> getAllUserPaged(int pageNo);

    void deleteUserById(Integer id);
   User saveUser(User user);
}
