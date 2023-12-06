package com.elixr.microsoftbot.config;

import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.integration.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@ConfigurationProperties
public class BotConfig {

    @Value("${bot.microsoftAppId}")
    private String microsoftAppId;

    @Value("${bot.microsoftAppPassword}")
    private String microsoftAppPassword;

    @Bean
    public BotFrameworkHttpAdapter botFrameworkHttpAdapter() {
        Configuration configuration = new Configuration() {
            @Override
            public String getProperty(String key) {
                if ("MicrosoftAppId".equals(key)) {
                    return microsoftAppId;
                } else if ("MicrosoftAppPassword".equals(key)) {
                    return microsoftAppPassword;
                }
                return null;
            }

            @Override
            public Properties getProperties() {
                return null;
            }

            @Override
            public String[] getProperties(String key) {
                return new String[0];
            }
        };
        return new BotFrameworkHttpAdapter(configuration);
    }
}
