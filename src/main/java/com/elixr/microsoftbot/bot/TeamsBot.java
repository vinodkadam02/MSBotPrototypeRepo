//package com.elixr.microsoftbot.bot;
//
//import com.microsoft.bot.builder.ActivityHandler;
//import com.microsoft.bot.builder.MessageFactory;
//import com.microsoft.bot.builder.TurnContext;
//import com.microsoft.bot.schema.Activity;
//import com.microsoft.bot.schema.ActivityTypes;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.CompletableFuture;
//
//@Component
//public class TeamsBot extends ActivityHandler {
//    public void onMessageActivity(TurnContext turnContext) {
//        Activity activity = turnContext.getActivity();
//        if (activity != null && activity.isType(ActivityTypes.MESSAGE)) {
//            String receivedMessage = activity.getText();
//            // Handle the received message
//            turnContext.sendActivity("Received: " + receivedMessage);
//        }
//    }
//
//    // Implement other required methods for bot functionality
////    public void onMessage(Activity turnContext) {
////        String message = turnContext.getText();
////        System.out.println(message);
////        // Process the message or perform required actions based on the received message
////        // Send a reply or perform other operations as needed
////    }
//}
