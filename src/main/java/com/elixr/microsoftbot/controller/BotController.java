package com.elixr.microsoftbot.controller;

import com.elixr.microsoftbot.dto.BotMessageResponse;
import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.builder.TurnContextImpl;
import com.microsoft.bot.builder.teams.TeamsActivityHandler;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.schema.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
//@RequestMapping("/bot")
public class BotController extends TeamsActivityHandler {
    @Autowired
    private BotFrameworkHttpAdapter botFrameworkHttpAdapter;

    @PostMapping("/api/messages")
    public ResponseEntity<BotMessageResponse> handleBotMessages(@RequestBody Activity activity) {
        TurnContext turnContext = new TurnContextImpl(botFrameworkHttpAdapter, activity);
        onMessageActivity(turnContext); // Process incoming message asynchronously
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping("/api/messages")
//    public ResponseEntity<BotMessageResponse> handleBotMessages(@RequestBody Activity activity) {
//        BotAdapter adapter = new BotConfig().botFrameworkHttpAdapter();
//        TurnContext turnContext = new TurnContextImpl(adapter, activity);
//        CompletableFuture onmessage = onMessageActivity(turnContext);
//        BotMessageResponse response = new BotMessageResponse();
//        response.setSender("Message received from " + turnContext.getActivity().getFrom().getName());
//        response.setResponseMessage("Received message: " + onmessage.toString());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    //    @Override
//    public CompletableFuture<Void> onMessageActivity(TurnContext turnContext) {
//        if (turnContext.getActivity().isType(ActivityTypes.MESSAGE)) {
//            String text = turnContext.getActivity().getText();
//            String sender = turnContext.getActivity().getFrom().getName();
//            System.out.println("Message received from " + sender + ": " + text);
//            // Sending a response back to Teams asynchronously
//            return turnContext.sendActivity("Hello from your bot!")
//                    .thenApply(resourceResponse -> null); // Returning CompletableFuture<Void>
//        }
//        return CompletableFuture.completedFuture(null); // Return a completed future
//    }
    @Override
    public CompletableFuture<Void> onMessageActivity(TurnContext turnContext) {
        // Simple logic to respond to a user's message
        String userInput = turnContext.getActivity().getText().toLowerCase();
        if (userInput.equals("hello")) {
            turnContext.sendActivity(MessageFactory.text("Hi there!"));
            System.out.println("Hi there!");
        } else if (userInput.equals("help")) {
            turnContext.sendActivity(MessageFactory.text("I'm here to help. What do you need?"));
            System.out.println("I'm here to help. What do you need?");
        } else {
            turnContext.sendActivity(MessageFactory.text("Sorry, I didn't get that."));
            System.out.println("Sorry, I didn't get that.");
        }
        return CompletableFuture.completedFuture(null);
    }
}