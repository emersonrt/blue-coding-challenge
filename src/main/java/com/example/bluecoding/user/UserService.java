package com.example.bluecoding.user;

public interface UserService {
    Long create(UserForm userForm);

    UserDTO findById(Long id);

    UserDTO update(UserForm userForm, Long id);

    void delete(Long id);
}
