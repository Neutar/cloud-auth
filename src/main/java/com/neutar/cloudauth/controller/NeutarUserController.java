package com.neutar.cloudauth.controller;

import com.neutar.cloudauth.controller.response.RegisterUserResponse;
import com.neutar.cloudauth.controller.response.ResetPasswordTokenResponse;
import com.neutar.cloudauth.dto.RegisterUserDto;
import com.neutar.cloudauth.dto.RegisterUserWithVerificationDto;
import com.neutar.cloudauth.dto.ResetPasswordDto;
import com.neutar.cloudauth.mapper.NeutarUserMapper;
import com.neutar.cloudauth.service.NeutarUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class NeutarUserController {
    private final NeutarUserService neutarUserService;
    private final NeutarUserMapper neutarUserMapper;

    @GetMapping("/me")
    public Principal user(Principal principal){
        return principal;
    }

    @PostMapping("/registerWithVerification")
    public RegisterUserResponse registerUserWithVerification(@RequestBody RegisterUserWithVerificationDto registerUserWithVerificationDto){
        UUID passwordResetToken = neutarUserService.registerUserWithVerification(registerUserWithVerificationDto);
        return RegisterUserResponse.builder().passwordResetToken(passwordResetToken).build();
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterUserDto registerUserDto){
        neutarUserService.registerUser(registerUserDto);
    }

    @PutMapping("/resetPassword")
    public void resetPassword(@RequestBody ResetPasswordDto resetPasswordDto, Principal principal){
        neutarUserService.resetPassword(resetPasswordDto, principal.getName());
    }

    @PutMapping("/resetPasswordToken")
    public ResetPasswordTokenResponse resetPasswordToken(Principal principal){
        UUID resetPasswordToken = neutarUserService.resetPasswordToken(principal.getName());
        return ResetPasswordTokenResponse.builder().passwordResetToken(resetPasswordToken).build();
    }

}
