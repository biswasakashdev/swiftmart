package com.biswasakashdev.swiftmart.templatebuilder.ai.structures;

import java.util.List;


public record PageTemplate(
        String title,
        String description,
        List<PageNode> nodes
) {}
