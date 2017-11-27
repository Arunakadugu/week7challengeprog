package me.afua.thymeleafsecdemo.controllers;

import me.afua.thymeleafsecdemo.entities.JobSeekers;

import me.afua.thymeleafsecdemo.entities.UserData;

import me.afua.thymeleafsecdemo.repositories.JobSeekersRepository;
import me.afua.thymeleafsecdemo.repositories.RoleRepository;
import me.afua.thymeleafsecdemo.repositories.UserRepository;

import me.afua.thymeleafsecdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JobSeekersRepository jobseekersRepository;

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/")
     public String index(){
     return "index";
}


    @GetMapping("/registration")
    public String showRegistrationPage(Model model){
        model.addAttribute("userData", new UserData ());
        model.addAttribute("userData","");
        return "registration";
    }

    @PostMapping("/registration")
    public String processRegistrationPage(
            @Valid @ModelAttribute("user") UserData user,
            BindingResult result,
            Model model){

        model.addAttribute("userData", user);

        if (result.hasErrors()) {
            return "registration";
        } else {
            userService.saveUserData(user);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "login";
    }

    //now its JobSeekers
    @GetMapping("/JobSeekers")
    public String jobSeekers(Model model) {
        model.addAttribute("JobSeekers", new JobSeekers());
        return "JobSeekers";

    }
    @PostMapping("/process")
    public String process(
            @Valid  JobSeekers jobseekers,
            BindingResult result,
            Model model){

        model.addAttribute("JobSeekers", jobseekers);

        if (result.hasErrors()) {
            return "JobSeekers";
        } else {
            jobseekersRepository.save(jobseekers);
            model.addAttribute("message", "User Successfully Insert there information");
        }
        return "show";
    }



    @RequestMapping("show/{id}")
    public String showJobSeekers(@PathVariable("id") long id, Model model){
        model.addAttribute("JobSeekers",jobseekersRepository.findOne(id));
        return"Show";
    }

    @RequestMapping ("/jobSeekers/search")
    public String Search()
    {
        return "search";
    }

//    @PostMapping("/search")
//    public String showSearchResults(HttpServletRequest request, Model model)
//    {
//        //Get the search string from the result form
//        String searchString = request.getParameter("search");
//        model.addAttribute("search",searchString);
//        model.addAttribute("employees",employeeRepository.findOneBySkillContainingIgnoreCase(searchString));
//        return "list";
//    }
    @RequestMapping("/recruiter/show/id" )
    public String showResume(@PathVariable("id") long id,Model model){
        model.addAttribute("jobSeekers",jobseekersRepository.findOne(id));
        return "show";
    }
}