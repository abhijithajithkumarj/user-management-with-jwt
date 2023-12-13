package com.javaangularproject.usermanagementwithjwt.repository;


import com.javaangularproject.usermanagementwithjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "SELECT * FROM roles WHERE role_name = :name", nativeQuery = true)
    Optional<Role> findRoleByName(@Param("name") String name);
}
