package com.biswasakashdev.swiftmart.templatebuilder.service.impl;

import com.biswasakashdev.swiftmart.templatebuilder.ai.service.TemplateAIService;
import com.biswasakashdev.swiftmart.templatebuilder.ai.structures.PageTemplate;
import com.biswasakashdev.swiftmart.templatebuilder.service.TemplateService;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateAIService templateAIService;

    public TemplateServiceImpl(ChatModel chatModel) {
        templateAIService = AiServices
                .builder(TemplateAIService.class)
                .chatModel(chatModel)
                .build();
    }

    @Override
    public void generateTemplate(String shopId, String userPrompt) {
        PageTemplate pageTemplate = templateAIService.generatePage(userPrompt);

    }
}
