package com.dirk.demo.datasource.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dirk.demo.datasource.mysql.entity.User;

public interface UserRepositry extends JpaRepository<User, Long>{

}