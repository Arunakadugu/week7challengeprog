package me.afua.thymeleafsecdemo.repositories;

import me.afua.thymeleafsecdemo.entities.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleRepository extends CrudRepository<UserRole,Long> {
    UserRole findByRole(String role);

}

