package com.neutar.cloudauth.mapper;

import com.neutar.cloudauth.controller.response.RegisterUserResponse;
import com.neutar.cloudauth.domain.NeutarUser;
import com.neutar.cloudauth.dto.RegisterUserDto;
import com.neutar.cloudauth.dto.RegisterUserWithVerificationDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NeutarUserMapper {
    @Mapping(target = "password", source = "encodedPassword")
    NeutarUser mapNeutarUserFrom(RegisterUserDto registerUserDto, String encodedPassword);

    NeutarUser mapNeutarUserFrom(RegisterUserWithVerificationDto registerUserDto);

    RegisterUserResponse mapRegisterUserResponseFrom(RegisterUserDto registerUserDto);
}
