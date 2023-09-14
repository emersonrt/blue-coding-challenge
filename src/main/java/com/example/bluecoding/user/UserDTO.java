package com.example.bluecoding.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    // DTO for sending data to the client

    private Long id;
    private String name;
    private String email;
    private Integer age;

}
