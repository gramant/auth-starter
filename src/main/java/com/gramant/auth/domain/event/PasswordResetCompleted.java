package com.gramant.auth.domain.event;

import com.gramant.auth.domain.User;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class PasswordResetCompleted {

    private final User user;
    private final String newPassword;

    public PasswordResetCompleted(User user, String newPassword) {
        this.user = user;
        this.newPassword = newPassword;
    }
}
