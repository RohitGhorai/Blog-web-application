package com.example.bloggingapplication.repositories;

import com.example.bloggingapplication.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
