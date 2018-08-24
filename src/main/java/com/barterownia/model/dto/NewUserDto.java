package com.barterownia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDto {
    private String username;
    private String password;
    private String confirmPassword;
}
