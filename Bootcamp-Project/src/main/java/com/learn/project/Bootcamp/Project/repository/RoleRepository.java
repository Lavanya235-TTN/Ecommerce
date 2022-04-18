package com.learn.project.Bootcamp.Project.repository;

import com.learn.project.Bootcamp.Project.model.Users.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);
}
