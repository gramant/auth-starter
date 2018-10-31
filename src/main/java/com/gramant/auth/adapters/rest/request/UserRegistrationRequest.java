package com.gramant.auth.adapters.rest.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gramant.auth.domain.PrivilegedRole;
import com.gramant.auth.domain.User;
import com.gramant.auth.domain.UserId;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.function.Function;

import static java.util.Collections.singletonList;

@Getter
public class UserRegistrationRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String id;

    @NotEmpty
    @Size(min = 8)
    private String password;

    private Map<String, String> additionalProperties;

    @JsonCreator
    public UserRegistrationRequest(@JsonProperty("email") String email,
                                   @JsonProperty("id") String id,
                                   @JsonProperty("password") String password,
                                   @JsonProperty("additionalProperties") Map<String, String> additionalProperties) {
        this.email = email;
        this.password = password;
        this.id = id;
        this.additionalProperties = additionalProperties;
    }

    public User asUserWithMappedPassword(Function<String, String> passwordMapper, PrivilegedRole defaultRole) {
        return User.builder().email(email).password(passwordMapper.apply(password)).id(UserId.of(id))
                .roles(singletonList(defaultRole)).build();
    }
}