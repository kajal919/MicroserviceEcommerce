package com.scaler.userservicejan31capstone.DTO;

import lombok.Getter;
import lombok.Setter;


public class LogoutResponseDTO {
    private String message;

    public LogoutResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
