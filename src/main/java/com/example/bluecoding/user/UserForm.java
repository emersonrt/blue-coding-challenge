package com.example.bluecoding.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class UserForm {
    // DTO for receiving data from the client

    @NotFound
    @Size(min = 3, max = 50)
    private final String name;
    @Email
    private final String email;
    @Min(18)
    @Max(120)
    private final Integer age;

}
