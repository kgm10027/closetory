package com.example.closetory.color;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/color")
public class ColorExplainController {

    private final ColorExplainService explainService;

    public ColorExplainController(ColorExplainService explainService) {
        this.explainService = explainService;
    }

    @GetMapping("/explain")
    public Map<String, Object> getExplain(@RequestParam String color) {

        List<String> list = explainService.getExplanation(color);

        Map<String, Object> response = new HashMap<>();
        response.put("color", color);

        List<Map<String, String>> converted = new ArrayList<>();
        for (String reason : list) {
            Map<String, String> entry = new HashMap<>();
            entry.put("reason", reason);
            converted.add(entry);
        }

        response.put("matches", converted);

        return response;
    }
}
