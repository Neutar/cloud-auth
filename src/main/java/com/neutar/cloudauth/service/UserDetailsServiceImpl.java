package com.neutar.cloudauth.service;

import com.neutar.cloudauth.domain.NeutarUser;
import com.neutar.cloudauth.dto.CustomGrantedAuthority;
import com.neutar.cloudauth.dto.CustomUserDetails;
import com.neutar.cloudauth.repository.NeutarUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final NeutarUserRepository neutarUserRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NeutarUser neutarUser = neutarUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return CustomUserDetails.builder()
                .username(neutarUser.getUsername())
                .password(neutarUser.getPassword())
                .authorities(neutarUser.getAuthorities().stream().map(CustomGrantedAuthority::new).collect(Collectors.toSet()))
                .build();

    }

}