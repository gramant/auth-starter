package com.gramant.auth.adapters.rest.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gramant.auth.domain.RoleId;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Getter
public class UserUpdateRequest {

    @NotNull
    private Boolean nonLocked;

    @NotEmpty
    private String email;

    @NotEmpty
    private List<RoleId> roles;

    @JsonCreator
    public UserUpdateRequest(@JsonProperty("nonLocked") Boolean nonLocked,
                             @JsonProperty("email") String email,
                             @JsonProperty("roles") List<RoleId> roles) {
        this.nonLocked = nonLocked;
        this.email = email;
        this.roles = Optional.ofNullable(roles).orElse(emptyList());
    }

}