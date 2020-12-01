package com.max.spring.rest.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "id")
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Transient
    private Map<String, String> roles;

    @Transient
    private Map<String, Boolean> enableds;


    {
        roles = new HashMap<>();
        roles.put("Employee", "EMPLOYEE");
        roles.put("Client", "CLIENT");

        enableds = new HashMap<>();
        enableds.put("False", false);
        enableds.put("True", true);
    }

    public User(Long id, String username, String password, String role, boolean enabled, BigDecimal salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.salary = salary;
    }
}
