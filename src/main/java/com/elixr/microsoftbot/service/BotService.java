package com.elixr.microsoftbot.service;

import org.springframework.stereotype.Service;

@Service
public class BotService {

    public String processMessage(String message) {
        // Process the received message and return a response
        return "Received: " + message;
    }
}
