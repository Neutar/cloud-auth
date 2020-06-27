package com.neutar.cloudauth.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Value
@Builder
public class ResetPasswordDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private UUID passwordResetToken;

}
