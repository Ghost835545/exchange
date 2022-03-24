package com.app.exchange.controller;


import com.app.exchange.repo.ExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


public class MainController {
    @Autowired
    private ExchangeRepo repo;



    public void greeting(){

    }
}
