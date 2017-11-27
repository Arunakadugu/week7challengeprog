package me.afua.thymeleafsecdemo.repositories;

import me.afua.thymeleafsecdemo.entities.JobSeekers;

import org.springframework.data.repository.CrudRepository;

public interface JobSeekersRepository extends CrudRepository<JobSeekers,Long> {
}
