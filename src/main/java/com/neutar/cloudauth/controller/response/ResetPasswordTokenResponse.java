package com.neutar.cloudauth.controller.response;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ResetPasswordTokenResponse {
    private UUID passwordResetToken;
}
