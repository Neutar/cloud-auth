package com.neutar.cloudauth.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class OauthClientDetails {

    @Id
    @GeneratedValue
    private UUID id;

    private String clientId;

    private String clientName;

    private String resourceIds;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    private Integer autoapprove;

    private String uuid;

    private Date created;

    private Boolean enabled;

    @Transient
    private String[] scopes;

    @Transient
    private String[] grantTypes;

    @Transient
    private String ownerEmail;

}
