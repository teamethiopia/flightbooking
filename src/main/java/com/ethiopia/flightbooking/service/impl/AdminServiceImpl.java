package com.ethiopia.flightbooking.service.impl;

import com.ethiopia.flightbooking.model.Admin;
import com.ethiopia.flightbooking.repository.AdminRepository;
import com.ethiopia.flightbooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class AdminServiceImpl implements AdminService
{

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Page<Admin> getAllAdminsPaged(int pageNo) {
        return adminRepository.findAll(PageRequest.of(pageNo,20));
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAdminById(Integer id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
