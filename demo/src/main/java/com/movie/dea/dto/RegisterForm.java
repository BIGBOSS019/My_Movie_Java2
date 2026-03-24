package com.movie.dea.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterForm {
    @NotBlank
    @Size(min = 3 , max = 15)
    @Pattern(
            regexp = "^[a-zA-Z0-9_]+$" ,
            message = "Username can contain only letters, digits, underscore!"
    )   //regexp Робота над строками!  ^ - Начало строки $ - Конец строки
    // + - Означает что может ввести данные символы несколько раз
    private String username;
    @NotBlank
    @Size(min = 8 , max = 80)
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*+=]).{8,}$" ,
            message = "Password should include upper , lower, digit and special char"
    )


    private String password;

    @NotBlank( message = "Please Confirm Password!")
    private String confirmPassword;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}