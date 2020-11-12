package com.bta.brokeremulator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bta.brokeremulator.model.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);

    UserAccount findByEmail(String email);
}
