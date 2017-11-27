package me.afua.thymeleafsecdemo.entities;

import me.afua.thymeleafsecdemo.repositories.JobSeekersRepository;
import me.afua.thymeleafsecdemo.repositories.RoleRepository;
import me.afua.thymeleafsecdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JobSeekersRepository jobSeekersRepository;
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data . . .");

        roleRepository.save(new UserRole ( "User" ));
        roleRepository.save(new UserRole ("Jobseekers"));

        UserRole adminRole = roleRepository.findByRole("User");
        UserRole userRole = roleRepository.findByRole("Jobseekers");
    }
}