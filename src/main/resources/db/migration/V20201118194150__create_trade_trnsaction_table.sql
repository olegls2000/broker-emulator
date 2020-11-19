CREATE SEQUENCE TRADE_TRANSACTION_SEQ;

CREATE TABLE TRADE_TRANSACTION
(
    id              INTEGER PRIMARY KEY,
    sticker         VARCHAR(10)                          NOT NULL,
    amount          integer                              NOT NULL,
    price           double precision                     NOT NULL,
    user_account_id integer REFERENCES user_account (id) NOT NULL
);