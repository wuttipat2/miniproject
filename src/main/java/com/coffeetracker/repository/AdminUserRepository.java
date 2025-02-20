package com.coffeetracker.repository;

import com.coffeetracker.dto.AdminUserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.coffeetracker.Entity.AdminUserPermission;

import java.util.Optional;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUserPermission, Long> {

    @Query(value = "SELECT username, full_name, org_name, email " +
            "FROM admin_user_permission " +
            "WHERE username = :username " +
            "LIMIT 1", nativeQuery = true)
    Optional<AdminUserProjection> findByUsername(@Param("username") String username);
}
