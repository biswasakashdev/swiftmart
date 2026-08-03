package com.biswasakashdev.swiftmart.templatebuilder.config;


import dev.langchain4j.model.chat.Capability;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ModelConfig {

    private final ApplicationConfig applicationConfig;

    @Bean(name = "templateModel")
    ChatModel model(){
        return GoogleAiGeminiChatModel.builder()
                .modelName(applicationConfig.googleModelName())
                .apiKey(applicationConfig.googleApiKey())
                .temperature(0.2)
                .supportedCapabilities(Capability.RESPONSE_FORMAT_JSON_SCHEMA) // This enables structured outputs.
                .build();
    }

}
