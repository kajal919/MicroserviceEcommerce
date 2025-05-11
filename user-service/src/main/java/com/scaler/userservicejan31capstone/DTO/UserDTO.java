package com.scaler.userservicejan31capstone.DTO;


import com.scaler.userservicejan31capstone.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//User response DTO
public class UserDTO {
    private String name;
    private String email;
    private String password;

    public static UserDTO from(User user) {
        if(user == null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.name = user.getName();
        userDTO.email = user.getEmail();
        userDTO.password = user.getPassword();
        return userDTO;
    }
}
