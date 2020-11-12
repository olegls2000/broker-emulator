package com.bta.brokeremulator.controller;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bta.brokeremulator.model.UserAccount;
import com.bta.brokeremulator.service.UserAccountService;

@Controller
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/user/registration")
    public String getRegistrationView() {
        return "registration";
    }

    @PostMapping("/user/registration")
    public ResponseEntity<UserAccount> registerUser(@RequestBody UserAccount userAccount) {
        UserAccount registeredUserAccount = userAccountService.save(userAccount);
        return new ResponseEntity<>(registeredUserAccount, OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserAccount> loginUser(@RequestParam(name = "username") String login,
                                                 @RequestParam String password) {
        final UserAccount registeredUserAccount = userAccountService.login(login, password);
        if (registeredUserAccount == null) {
            return new ResponseEntity<>(registeredUserAccount, FORBIDDEN);
        }
        return new ResponseEntity<>(registeredUserAccount, OK);
    }

}
