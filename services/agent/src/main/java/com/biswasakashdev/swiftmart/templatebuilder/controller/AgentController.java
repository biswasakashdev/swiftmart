package com.biswasakashdev.swiftmart.templatebuilder.controller;


import com.biswasakashdev.swiftmart.templatebuilder.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/agent")
public class AgentController {


    private final TemplateService templateService;


    @PostMapping("/{shopId}/generate")
    void createTemplate(@PathVariable String shopId, String userPrompt){
        templateService.generateTemplate(shopId,userPrompt);
    }

}
