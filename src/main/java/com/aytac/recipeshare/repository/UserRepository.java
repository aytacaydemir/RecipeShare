package com.aytac.recipeshare.repository;

import com.aytac.recipeshare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {

}
