ALTER TABLE user_account
    ALTER column password TYPE varchar(70) using NOT NULL;
ALTER TABLE user_account
    ADD column active boolean NOT NULL;
--truncate user_account;