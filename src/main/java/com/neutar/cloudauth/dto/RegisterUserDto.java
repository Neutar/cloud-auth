package com.neutar.cloudauth.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Value
@Builder
public class RegisterUserDto {
    @NotBlank
    private String username;

    private String password;

    @Builder.Default
    private Set<String> authorities = new HashSet<>();
}
