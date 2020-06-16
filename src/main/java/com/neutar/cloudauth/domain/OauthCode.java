package com.neutar.cloudauth.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.UUID;

@Entity
@Data
public class OauthCode {

    @Id
    @GeneratedValue
    private UUID id;

    private String code;

    @Lob
    private byte[] authentication;

}
