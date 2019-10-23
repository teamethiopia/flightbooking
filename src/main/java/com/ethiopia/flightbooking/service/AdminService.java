package com.ethiopia.flightbooking.service;


import com.ethiopia.flightbooking.model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface AdminService
{
    Page<Admin> getAllAdminsPaged(int pageNo);
    Admin getAdminById(Integer id);
    void deleteAdminById(Integer id);
    Admin saveAdmin(Admin admin);
}
