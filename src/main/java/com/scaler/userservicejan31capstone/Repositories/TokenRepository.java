package com.scaler.userservicejan31capstone.Repositories;

import com.scaler.userservicejan31capstone.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token save(Token token);

}
