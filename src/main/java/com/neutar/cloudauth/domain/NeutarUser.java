package com.neutar.cloudauth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NeutarUser {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;

    private String password;

    private Boolean accountExpired;

    private Boolean accountLocked;

    private Boolean enabled;

    @ElementCollection
    @CollectionTable(name="neutar_user_authority")
    @Column(name="authority")
    @Builder.Default
    private Set<String> authorities = new HashSet<>();

}
