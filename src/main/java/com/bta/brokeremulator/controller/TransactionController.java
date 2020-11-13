package com.bta.brokeremulator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @GetMapping("/transaction/get")
    public String getTransaction() {
        return "Hello from Transaction";
    }
}
