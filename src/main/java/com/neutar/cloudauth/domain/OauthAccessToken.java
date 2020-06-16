package com.neutar.cloudauth.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.UUID;

@Entity
@Data
public class OauthAccessToken {

    @Id
    @GeneratedValue
    private UUID id;

    private String tokenId;

    @Lob
    private byte[] token;

    private String authenticationId;

    private String userName;

    private String clientId;

    @Lob
    private byte[] authentication;

    private String refreshToken;

}