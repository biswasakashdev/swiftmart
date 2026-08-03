package com.biswasakashdev.swiftmart.templatebuilder.ai.service;

import com.biswasakashdev.swiftmart.templatebuilder.ai.structures.PageTemplate;
import com.biswasakashdev.swiftmart.templatebuilder.config.AiServiceConfig;
import com.biswasakashdev.swiftmart.templatebuilder.config.ApplicationConfig;
import com.biswasakashdev.swiftmart.templatebuilder.config.ModelConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class, ModelConfig.class, AiServiceConfig.class})
@ActiveProfiles(value = "test")
class TemplateAIServiceTest {

    @Autowired
    private TemplateAIService templateAIService;



    @Test
    void shouldGenerateAValidTemplate() {
    }

}