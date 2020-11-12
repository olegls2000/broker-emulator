package com.bta.brokeremulator.service;

import com.bta.brokeremulator.model.UserAccount;


public interface UserAccountService {

    UserAccount save(UserAccount userAccount);

    UserAccount login(String username, String password);
}
