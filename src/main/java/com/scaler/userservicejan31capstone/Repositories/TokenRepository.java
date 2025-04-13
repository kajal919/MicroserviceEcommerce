package com.scaler.userservicejan31capstone.Repositories;

import com.scaler.userservicejan31capstone.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token save(Token token);
    // Check all three conditions for token
    Optional<Token> findByValue(String value);
    Optional<Token> findByValueAndDeletedAndExpiresAtGreaterThan(String value, boolean deleted, Date expiryAt);

}
