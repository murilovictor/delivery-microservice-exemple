package com.mvictor.delivery.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(updatable = false, nullable = false)
    private String username;

    @Size(min = 0, max = 500)
    private String password;

    @Email
    @Size(min = 0, max = 50)
    private String email;

    private boolean activated;

    @Size(min = 0, max = 100)
    @Column(name = "activationkey")
    private String activationKey;

    @Size(min = 0, max = 100)
    @Column(name = "resetpasswordkey")
    private String resetPasswordKey;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<Authority> authorities;

    public User() {
    }

    public User(String username, String password, String email,
                boolean activated, String firstName, String lastName,
                String activationKey, String resetPasswordKey,
                Set<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.activated = activated;
        this.activationKey = activationKey;
        this.resetPasswordKey = resetPasswordKey;
        this.authorities = authorities;
    }

}