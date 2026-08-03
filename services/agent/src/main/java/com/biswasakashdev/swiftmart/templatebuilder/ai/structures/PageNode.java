package com.biswasakashdev.swiftmart.templatebuilder.ai.structures;


import java.util.List;
import java.util.Map;


public record PageNode(
        String id,
        String parentId,
        String tag,
        List<String> classes,
        Map<String, String> attributes,
        Map<String, String> htmx,
        String text
) {}
