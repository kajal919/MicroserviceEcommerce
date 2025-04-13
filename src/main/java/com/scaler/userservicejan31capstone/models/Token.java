package com.scaler.userservicejan31capstone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Token extends Base {
    private String value;
    private Date expiresAt;

    @ManyToOne
    private User user;
}

/*
* User ------- Token
*  1 --------- M
*  1 --------- 1
*  User:Token = 1:M
* */

