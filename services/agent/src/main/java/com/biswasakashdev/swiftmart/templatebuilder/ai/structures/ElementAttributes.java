package com.biswasakashdev.swiftmart.templatebuilder.ai.structures;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Common HTML Attributes.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ElementAttributes(
        String type,
        String placeholder,
        String href,
        String name,
        String value
) {}