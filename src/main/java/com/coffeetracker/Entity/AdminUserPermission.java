package com.coffeetracker.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "admin_user_permission")
@Getter
@Setter
@NoArgsConstructor
public class AdminUserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "full_name", length = 255, nullable = true)
    private String fullName;

    @Column(name = "org_name", length = 255, nullable = true)
    private String orgName;

    @Column(name = "email", unique = true, length = 255, nullable = false)
    private String email;

    @Column(name = "employee_id", length = 15, nullable = true)
    private String employeeId;

    @Column(name = "org_code", length = 10, nullable = true)
    private String orgCode;

    @Column(name = "menu_id", nullable = true)
    private UUID menuId;

    @Column(name = "sub_menu_id", nullable = true)
    private UUID subMenuId;

    @Column(name = "sub_menu_module_id", nullable = true)
    private UUID subMenuModuleId;

    @Column(name = "sub_menu_activity_id", nullable = true)
    private UUID subMenuActivityId;

    @Column(name = "view_flag", nullable = true)
    private Boolean viewFlag;

    @Column(name = "create_flag", nullable = true)
    private Boolean createFlag;

    @Column(name = "update_flag", nullable = true)
    private Boolean updateFlag;

    @Column(name = "delete_flag", nullable = true)
    private Boolean deleteFlag;

    @Column(name = "status", length = 10, nullable = true)
    private String status;

    @Column(name = "display_flag", nullable = true)
    private Boolean displayFlag;

    @Column(name = "create_time", columnDefinition = "TIMESTAMP", nullable = true)
    private java.time.LocalDateTime createTime;

    @Column(name = "create_user_code", length = 100, nullable = true)
    private String createUserCode;

    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = true)
    private java.time.LocalDateTime lastUpdate;

    @Column(name = "update_user_code", length = 100, nullable = true)
    private String updateUserCode;
}
