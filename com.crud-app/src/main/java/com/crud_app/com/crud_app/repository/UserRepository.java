package com.crud_app.com.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_app.com.crud_app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
