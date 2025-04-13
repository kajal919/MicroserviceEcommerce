package com.scaler.userservicejan31capstone.Service;

import com.scaler.userservicejan31capstone.models.Token;
import com.scaler.userservicejan31capstone.models.User;

public interface UserService {
    User signUp(String name, String email, String password);
    Token login(String email, String password);
    void logout(String tokenValue);
    User validateToken(String tokenValue);



}
