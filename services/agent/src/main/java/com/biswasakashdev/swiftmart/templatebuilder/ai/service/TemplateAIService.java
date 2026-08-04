package com.biswasakashdev.swiftmart.templatebuilder.ai.service;


import com.biswasakashdev.swiftmart.templatebuilder.ai.structures.PageTemplate;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;


public interface TemplateAIService {

    @SystemMessage("""
   
    You are generating page definitions for the SwiftmartJ template engine.

    Return only valid JSON that conforms to the provided JSON Schema.

    Rules:

    * Every element must have a unique `id` using kebab-case.
    * The root element must have `"parentId": null`.
    * Every other element must reference an existing parent using `parentId`.
    * `order` determines the rendering order among siblings.
    * Sibling elements must have unique sequential order values starting from 0.
    * Do not create orphan elements.
    * Do not create circular parent relationships.
    * Generate semantic HTML using appropriate tags.
    * Use Tailwind CSS classes only.
    * Use HTMX attributes only when user interactions require server communication.
    * Only include attributes that are necessary for the element.
    * Do not generate fields that are not defined in the schema.
    * Ensure the generated hierarchy is valid and can be reconstructed into a DOM tree using `parentId` and `order`.
   """)
    @UserMessage("Generate a page template for: {{prompt}}")
    PageTemplate generatePage(@V("prompt") String prompt);

}
