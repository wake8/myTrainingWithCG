package com.vunnam.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vunnam.Model.Customer;

@Repository
public interface MyRepo extends JpaRepository<Customer, String> {

}
