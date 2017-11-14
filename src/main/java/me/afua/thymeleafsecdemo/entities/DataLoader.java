package me.afua.thymeleafsecdemo.entities;

import me.afua.thymeleafsecdemo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner{
    @Autowired
    RoleRepository roleRepository;

    public void run(String... strings) throws Exception
    {
        System.out.println("Loading data ....");
        roleRepository.save(new UserRole("USER"));
        roleRepository.save(new UserRole("ADMIN"));
    }

}
