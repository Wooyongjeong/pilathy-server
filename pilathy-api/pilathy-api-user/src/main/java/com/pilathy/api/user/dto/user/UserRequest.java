package com.pilathy.api.user.dto.user;

import com.pilathy.api.user.config.validator.Password;
import com.pilathy.api.user.config.validator.Phone;
import com.pilathy.domain.rds.domain.account.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @Email
    private String email;

    @Password
    private String password;

    @NotBlank
    @Size(max = 20)
    private String name;

    private LocalDate birthDate;

    @Phone
    private String phone;

    public User toEntity() {
        return User.of(email, password, name, birthDate, phone);
    }
}
