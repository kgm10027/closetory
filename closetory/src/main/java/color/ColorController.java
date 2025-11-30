package com.example.closetory.color;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorController {

    private final com.example.closetory.color.ColorRecommendService service;

    public ColorController(com.example.closetory.color.ColorRecommendService service) {
        this.service = service;
    }
    @GetMapping("/recommend")
    public List<String> recommend(@RequestParam String color) {
        return service.recommend(color);
    }

}
