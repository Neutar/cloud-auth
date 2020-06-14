package com.neutar.authorizationserveroauth2.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
@EnableConfigurationProperties(ClientProperties.class)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final ClientProperties clientProperties;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder inMemoryClientDetailsServiceBuilder = clients.inMemory();

        for (Client client : clientProperties.getClientList()) {
            inMemoryClientDetailsServiceBuilder
                    .withClient(client.getClientId())
                    .secret(passwordEncoder.encode(client.getClientSecret()))
                    .authorizedGrantTypes("authorization_code")
                    .scopes("user_info")
                    .autoApprove(true)
                    .redirectUris(client.getRedirectUris());
        }
    }
}
