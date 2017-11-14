package me.afua.thymeleafsecdemo.service;

import me.afua.thymeleafsecdemo.entities.UserData;
import me.afua.thymeleafsecdemo.repositories.RoleRepository;
import me.afua.thymeleafsecdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
public UserData findByEmail(String email){
        return userRepository.findbyEmail(email);
}
public Long countByEmail(String email){
    return userRepository.countByEmail(email);
}
public UserData findByUsername(String username){
    return userRepository.findByUsername(username);
}
public void saveUser(UserData userData){


    userData.addRoles(roleRepository.findByRole("USER"));
//    userData.setRoles((roleRepository.findByRole("USER")));
    userData.setEnabled(true);
    userRepository.save(userData);
}
public void saveAdmin(UserData userData){
//    userData.setRoles(roleRepository.findByRole("ADMIN"));

    userData.addRoles(roleRepository.findByRole("ADMIN"));
    userData.setEnabled(true);
    userRepository.save(userData);
}
}
