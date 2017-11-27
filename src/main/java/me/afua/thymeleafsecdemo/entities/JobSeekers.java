package me.afua.thymeleafsecdemo.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Job_Seekers")
public class JobSeekers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotNull
    @Size(min=2)
    private String name;

    @NotNull
    @Size(min=2)
    private String position;

    @NotNull
    @Size(min=2)
    private String education;

//    @NotNull
//    private String skills;

    @NotNull
    @Size(min=2)
    private String college;

    @NotNull
    @Size(min=2)
    private String yearOfEducation;

    @NotNull
    @Size(min=2)
    private String Experience;

    @ManyToMany(mappedBy = "skills")

    private Set<JobSeekers> jobSeekers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getYearOfEducation() {
        return yearOfEducation;
    }

    public void setYearOfEducation(String yearOfEducation) {
        this.yearOfEducation = yearOfEducation;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public JobSeekers(){
        this.skills = new HashSet<JobSeekers>();
    }

    @ManyToMany()
    private Set<JobSeekers> skills;
    public Set<JobSeekers> getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(Set<JobSeekers> roles) {
        this.jobSeekers = jobSeekers;
    }

    public void addJobSeekers(JobSeekers jobSeekers) {
        jobSeekers.addJobSeekers(jobSeekers);
    }


}