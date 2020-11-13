package com.bta.brokeremulator.controller;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bta.brokeremulator.model.UserAccount;
import com.bta.brokeremulator.service.UserAccountService;

@Controller
@RequestMapping("user")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("registration")
    public String getRegistrationView() {
        return "user/registration";
    }

    @PostMapping("registration")
    public ResponseEntity<UserAccount> registerUser(@ModelAttribute UserAccount userAccount) {
        UserAccount registeredUserAccount = userAccountService.save(userAccount);
        return new ResponseEntity<>(registeredUserAccount, OK);
    }

    @GetMapping("login")
    public String getLoginView() {
       return "user/login";
    }
}
