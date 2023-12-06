package com.elixr.microsoftbot.dto;

import lombok.Data;

@Data
public class BotMessageResponse {
    private String sender;
    private String responseMessage;
}
