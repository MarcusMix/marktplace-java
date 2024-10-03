package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
<<<<<<< HEAD
    boolean existsByEmail(String email);
=======
    
>>>>>>> 01a340a2634ce3cd5f4f891a18e72efd3c89d330
}
