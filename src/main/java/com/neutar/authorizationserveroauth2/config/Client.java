package com.neutar.authorizationserveroauth2.config;

import lombok.Data;

@Data
public class Client {
    private String clientId;
    private String clientSecret;
    private String redirectUris;
}
