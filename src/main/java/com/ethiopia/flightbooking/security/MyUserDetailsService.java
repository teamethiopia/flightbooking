//package com.ethiopia.flightbooking.security;
//
//import com.ethiopia.flightbooking.model.User;
//import com.ethiopia.flightbooking.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.security.Principal;
//
//
//@Service
//public class MyUserDetailsService implements UserDetailsService
//{
////    @Autowired
////    UserRepository userRepository;
////
////    @Override
////    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
////        User user = userRepository.findByUserName(s);
////        if(user == null)
////        {
////            throw new UsernameNotFoundException("User 404");
////        }
////        return new UserPrincipal(user);
////    }
////}
