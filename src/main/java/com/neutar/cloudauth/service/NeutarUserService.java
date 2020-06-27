package com.neutar.cloudauth.service;

import com.neutar.cloudauth.domain.NeutarUser;
import com.neutar.cloudauth.dto.RegisterUserDto;
import com.neutar.cloudauth.dto.RegisterUserWithVerificationDto;
import com.neutar.cloudauth.dto.ResetPasswordDto;
import com.neutar.cloudauth.exception.NeutarUserNotFoundException;
import com.neutar.cloudauth.mapper.NeutarUserMapper;
import com.neutar.cloudauth.repository.NeutarUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NeutarUserService {
    private final NeutarUserRepository neutarUserRepository;
    private final NeutarUserMapper neutarUserMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UUID registerUserWithVerification(RegisterUserWithVerificationDto registerUserDto) {
        NeutarUser neutarUser = neutarUserMapper.mapNeutarUserFrom(registerUserDto);
        neutarUser.disableUser();
        neutarUser = neutarUserRepository.save(neutarUser);
        return neutarUser.getPasswordResetToken();
    }

    @Transactional
    public void registerUser(RegisterUserDto registerUserDto) {
        NeutarUser neutarUser = neutarUserMapper.mapNeutarUserFrom(registerUserDto, passwordEncoder.encode(registerUserDto.getPassword()));
        neutarUserRepository.save(neutarUser);
    }

    @Transactional
    public void resetPassword(ResetPasswordDto resetPasswordDto) {
        NeutarUser neutarUser = neutarUserRepository.findByUsername(resetPasswordDto.getUsername()).orElseThrow(() -> new NeutarUserNotFoundException(resetPasswordDto.getUsername()));
        neutarUser.resetPassword(passwordEncoder.encode(resetPasswordDto.getPassword()), resetPasswordDto.getPasswordResetToken());
        neutarUserRepository.save(neutarUser);
    }

    @Transactional
    public UUID resetPasswordToken(String username) {
        NeutarUser neutarUser = neutarUserRepository.findByUsername(username).orElseThrow(() -> new NeutarUserNotFoundException(username));
        UUID newResetPasswordToken = neutarUser.createNewResetPasswordToken();
        neutarUserRepository.save(neutarUser);
        return newResetPasswordToken;
    }
}
