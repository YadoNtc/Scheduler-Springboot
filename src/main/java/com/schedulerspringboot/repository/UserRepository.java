package com.schedulerspringboot.repository;

import com.schedulerspringboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
