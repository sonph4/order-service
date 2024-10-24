package com.polarbookshop.orderservice.web;

import com.polarbookshop.orderservice.config.ClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    public HomeController(ClientProperties clientProperties) {
        this.clientProperties = clientProperties;
    }

    private final ClientProperties clientProperties;

    @GetMapping
    public String welcome() {
        return clientProperties.welcomeMessage();
    }
}
