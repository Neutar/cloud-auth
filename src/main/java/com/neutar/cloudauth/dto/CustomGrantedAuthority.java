package com.neutar.cloudauth.dto;

import lombok.Value;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Value
public class CustomGrantedAuthority implements GrantedAuthority, Serializable {
    private String authority;
}
