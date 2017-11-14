package me.afua.thymeleafsecdemo.controllers;

import me.afua.thymeleafsecdemo.service.UserService;
import me.afua.thymeleafsecdemo.entities.UserData;

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
    private UserService userService;


//    @RequestMapping(value="/register", method = RequestMethod.GET)
//    public String showRegistrationPages(Model model){
//        model.addAttribute("userData", new UserData());
//        return "registration";
//    }

//    @RequestMapping(value="/register", method = RequestMethod.POST)
//    public String processRegistrationPages(@Valid @ModelAttribute("userData") UserData userData, BindingResult result, Model model){
//        model.addAttribute("userData", userData);
//        System.out.println(result);
//        if(result.hasErrors()){
//            return "registration";
//        }
//        else{
//            userService.saveUser(userData);
//            model.addAttribute("message", "User Account Successfully Created");
//        }
//        return "index";
//    }
    @RequestMapping("/")
    public String showMainPage(Principal p) {

        return "index";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/pageone")
    public String showPageOne(Model model)
    {
        model.addAttribute("title","First Page");
        model.addAttribute("pagenumber","1");
        return "pageone";
    }


    @GetMapping("/register")
    public String showRegistrationPage(Model model)
    {
        model.addAttribute("userData",new UserData());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("userData") UserData userData,
                                          BindingResult bindingresult, Model model)
    {
        model.addAttribute("userData", userData);
        System.out.println(bindingresult);
        if(bindingresult.hasErrors()){
            return "registration";
        }
        else{
            userService.saveUser(userData);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "index";
    }
    @RequestMapping("/pagetwo")
    public String showPageTwo(Model model)
    {
        model.addAttribute("title","Second Page");
        model.addAttribute("pagenumber","2");
        return "pagetwo";
    }

    @RequestMapping("/pagethree")
    public String showPageThree(Model model)
    {
        model.addAttribute("title","Third Page");
        model.addAttribute("pagenumber","3");
        return "pagethree";
    }


}
