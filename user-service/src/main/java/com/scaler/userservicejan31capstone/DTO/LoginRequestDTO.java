package com.scaler.userservicejan31capstone.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    private String user;
    private String email;
    private String password;

}
