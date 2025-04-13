package com.scaler.userservicejan31capstone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends Base {
    String name;
    String email;
    String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> role;
}

/*
* User ----- Role
* 1  -------- M
* M --------- 1
* M:M
* */
