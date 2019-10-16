package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
