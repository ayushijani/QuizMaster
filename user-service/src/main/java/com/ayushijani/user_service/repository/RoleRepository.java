package com.ayushijani.user_service.repository;

import com.ayushijani.user_service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {}

