package com.elixr.microsoftbot.dto;

import lombok.Data;

@Data
public class BotMessageRequest {
    private String type;
    private From from;
    private String text;
}
