package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.constants.RoleName;
import com.nt.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}