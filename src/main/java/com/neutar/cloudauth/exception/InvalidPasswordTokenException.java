package com.neutar.cloudauth.exception;

import java.time.LocalDateTime;
import java.util.UUID;

public class InvalidPasswordTokenException extends RuntimeException {
    private static final String INVALID_PASSWORD_TOKEN = "Password token is invalid! UserId = %s, PasswordResetToken= %s, passwordResetTokenTime= %s";

    public InvalidPasswordTokenException(UUID userId, UUID passwordResetToken, LocalDateTime passwordResetTokenCreatedDate) {
        super(String.format(INVALID_PASSWORD_TOKEN, userId, passwordResetToken, passwordResetTokenCreatedDate));
    }
}
