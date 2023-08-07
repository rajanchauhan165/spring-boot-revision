package com.rajan.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rajan.spring.Entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
