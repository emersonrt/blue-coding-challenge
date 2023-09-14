package com.example.bluecoding.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long create(UserForm userForm) {
        User record = new User();
        record.setName(userForm.getName());
        record.setEmail(userForm.getEmail());
        record.setAge(userForm.getAge());

        return userRepository.save(record).getId();
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .build();
    }

    @Override
    public UserDTO update(UserForm userForm, Long id) {
        User record = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (userForm.getAge() != null) {
            record.setAge(userForm.getAge());
        }

        if (userForm.getEmail() != null) {
            record.setEmail(userForm.getEmail());
        }

        if (userForm.getName() != null) {
            record.setName(userForm.getName());
        }

        User updatedRecord = userRepository.save(record);
        return UserDTO.builder()
                .name(updatedRecord.getName())
                .email(updatedRecord.getEmail())
                .age(updatedRecord.getAge())
                .build();
    }

    @Override
    public void delete(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
    }
}
