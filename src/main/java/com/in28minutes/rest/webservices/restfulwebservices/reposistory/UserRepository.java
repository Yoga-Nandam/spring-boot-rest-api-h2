package com.in28minutes.rest.webservices.restfulwebservices.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;

@Component
public interface UserRepository extends  JpaRepository<User, Integer>{

}
