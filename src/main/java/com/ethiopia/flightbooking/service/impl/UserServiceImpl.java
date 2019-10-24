package com.ethiopia.flightbooking.service.impl;


import com.ethiopia.flightbooking.model.User;
import com.ethiopia.flightbooking.repository.UserRepository;
import com.ethiopia.flightbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;


    @Override
    public Page<User> getAllUserPaged(int pageNo) {
        return userRepository.findAll(PageRequest.of(pageNo,30));
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}





