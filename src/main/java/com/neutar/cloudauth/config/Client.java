package com.neutar.cloudauth.config;

import lombok.Data;

@Data
public class Client {
    private String clientId;
    private String clientSecret;
    private String redirectUris;
}
