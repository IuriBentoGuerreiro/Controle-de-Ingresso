package com.api.ingresso.Model;

import com.api.ingresso.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
