package com.scaler.userservicejan31capstone.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
@Entity
public class Role extends Base {
    String value;
}
