package com.bta.brokeremulator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bta.brokeremulator.model.UserAccount;
import com.bta.brokeremulator.repository.UserAccountRepository;
import com.bta.brokeremulator.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository repository;

    @Override
    public UserAccount save(UserAccount userAccount) {
        checkUsername(userAccount.getUsername());
        checkEmail(userAccount.getEmail());

        return repository.save(userAccount);
    }

    @Override
    public UserAccount login(String username, String password) {
        final UserAccount userFromDb = repository.findByUsername(username);
        if (password.equals(userFromDb.getPassword())) {
            return userFromDb;
        }
        return null;
    }

    private void checkUsername(String username) {
        final UserAccount userAccountFromDb = repository.findByUsername(username);
        if (userAccountFromDb != null) {
            throw new RuntimeException("User with username " + username + " already exist");
        }
    }

    private void checkEmail(String email) {
        final UserAccount userAccountFromDb = repository.findByEmail(email);
        if (userAccountFromDb != null) {
            throw new RuntimeException("User with email " + email + " already exist");
        }
    }
}
