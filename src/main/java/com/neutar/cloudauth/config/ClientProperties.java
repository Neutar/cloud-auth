package com.neutar.cloudauth.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConfigurationProperties(prefix = "clients")
@Value
@ConstructorBinding
public class ClientProperties {
    private List<Client> clientList;
}

