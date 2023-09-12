package com.exemple.usermanager.repos;

import com.exemple.usermanager.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRoleName(String roleName);
}
