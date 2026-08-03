package com.biswasakashdev.swiftmart.templatebuilder.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public record ApplicationConfig(
        @Value("${google.api-key}") String googleApiKey,
        @Value("${google.model-name}") String googleModelName
) {
}
