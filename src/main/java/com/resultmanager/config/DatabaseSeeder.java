package com.resultmanager.config;

import com.resultmanager.entity.Role;
import com.resultmanager.entity.User;
import com.resultmanager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private static final Logger LOGGER = Logger.getLogger(DatabaseSeeder.class.getName());

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Seed default admin if no admin exists
        if (userRepository.findByUsername("admin").isEmpty()) {
            User defaultAdmin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role(Role.ROLE_ADMIN)
                    .fullName("System Administrator")
                    .email("admin@result.com")
                    .build();
            userRepository.save(defaultAdmin);
            LOGGER.info("Seeded default admin user into database: username=admin, password=admin123");
        }
    }
}
