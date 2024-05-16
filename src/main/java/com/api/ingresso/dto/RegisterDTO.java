package com.api.ingresso.dto;

import com.api.ingresso.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
