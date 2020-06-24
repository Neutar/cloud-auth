package com.neutar.cloudauth.domain;

import com.neutar.cloudauth.exception.InvalidPasswordTokenException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
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

    @NotBlank
    private String username;

    private String password;

    @Builder.Default
    private UUID passwordResetToken = UUID.randomUUID();

    @Builder.Default
    private LocalDateTime passwordResetTokenCreatedDate = LocalDateTime.now();

    @NotNull
    @Builder.Default
    private Boolean accountExpired = false;

    @NotNull
    @Builder.Default
    private Boolean accountLocked = false;

    @NotNull
    @Builder.Default
    private Boolean enabled = true;

    @ElementCollection
    @CollectionTable(name="neutar_user_authority")
    @Column(name="authority")
    @Builder.Default
    private Set<String> authorities = new HashSet<>();

    public void disableUser(){
        this.enabled = false;
    }

    public void resetPassword(String password, UUID passwordResetToken) {
        if (this.passwordResetToken.equals(passwordResetToken) && passwordResetTokenCreatedDate.plusHours(2).isBefore(LocalDateTime.now())) {
            this.password = password;
            this.enabled = true;
            this.passwordResetToken = UUID.randomUUID();
            this.passwordResetTokenCreatedDate = LocalDateTime.of(2018,10,27,16,12);
        }
        throw new InvalidPasswordTokenException(id, passwordResetToken, passwordResetTokenCreatedDate);
    }

    public UUID createNewResetPasswordToken(){
        this.passwordResetTokenCreatedDate = LocalDateTime.now();
        this.passwordResetToken = UUID.randomUUID();
        return this.passwordResetToken;
    }
}
