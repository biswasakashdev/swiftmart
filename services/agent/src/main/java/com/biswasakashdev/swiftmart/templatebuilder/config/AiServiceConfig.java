package com.biswasakashdev.swiftmart.templatebuilder.config;


import com.biswasakashdev.swiftmart.templatebuilder.ai.service.TemplateAIService;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiServiceConfig {


    @Bean
    TemplateAIService templateAIService(@Qualifier("templateModel") ChatModel model){
        return AiServices
                .builder(TemplateAIService.class)
                .chatModel(model)
                .build();
    }
}
