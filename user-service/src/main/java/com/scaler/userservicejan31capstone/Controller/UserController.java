package com.scaler.userservicejan31capstone.Controller;

import com.scaler.userservicejan31capstone.DTO.*;
import com.scaler.userservicejan31capstone.Service.UserService;
import com.scaler.userservicejan31capstone.models.Token;
import com.scaler.userservicejan31capstone.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/register")
    public UserDTO signUp(@RequestBody SignupRequestDTO signupRequestDTO) {
        User user = userService.signUp(signupRequestDTO.getName(), signupRequestDTO.getEmail(), signupRequestDTO.getPassword() );

        return UserDTO.from(user);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Token token = userService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword() );
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setTokenValue(token.getValue());

        return loginResponseDTO;
    }

    @PostMapping("user/logout")
    public LogoutResponseDTO logout(@RequestBody LogoutRequestDTO logoutRequestDTO){

        userService.logout(logoutRequestDTO.getToken());
        LogoutResponseDTO response = new LogoutResponseDTO("Logout successful");
        return response;
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<Boolean> validateToken(@PathVariable("token") String token){
        User user = userService.validateToken(token);
        ResponseEntity<Boolean> responseEntity;
        if(user == null) {
            responseEntity = new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);

        }
        else {
            responseEntity = new ResponseEntity<>(true, HttpStatus.OK);

        }
        return responseEntity;

    }
}
