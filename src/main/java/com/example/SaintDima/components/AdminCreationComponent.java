package com.example.SaintDima.components;

import com.example.SaintDima.models.User;
import com.example.SaintDima.models.enums.Role;
import com.example.SaintDima.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminCreationComponent {

    @Autowired
    public AdminCreationComponent(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        addAdminInDB(userRepository, createAdmin(passwordEncoder));
        System.out.println("Добавление админа завершено!");
    }

    public static User createAdmin(PasswordEncoder passwordEncoder) {
        User admin = new User();
        admin.setEmail("ruslanfedosvich2019@gmail.com");
        admin.setRole(Role.ROLE_ADMIN);
        admin.setPassword(passwordEncoder.encode("123123"));

        return admin;
    }

    public static void addAdminInDB(UserRepository userRepository, User user) {
        if(userRepository.findByEmail(user.getEmail()).isEmpty()) {
            userRepository.save(user);

            System.out.println("Админ добавлен в базу данных!");
        }
    }
}
