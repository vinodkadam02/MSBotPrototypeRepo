package com.elixr.microsoftbot.controller;

import com.microsoft.bot.builder.TurnContext;
public interface BotControllerPrototype {
    void onTurnActivity(TurnContext turnContext);
}

