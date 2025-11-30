package com.example.closetory.color;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ColorRecommendService {

    public List<String> recommend(String color) {

        switch (color.toLowerCase()) {

            case "black":
                return List.of(
                        "화이트",
                        "그레이",
                        "라이트 블루",
                        "라임"
                );

            case "white":
                return List.of(
                        "블랙",
                        "네이비",
                        "버건디",
                        "베이지"
                );

            case "navy":
                return List.of(
                        "화이트",
                        "그레이",
                        "라이트 블루",
                        "카키"
                );

            case "gray":
                return List.of(
                        "블랙",
                        "화이트",
                        "민트",
                        "라이트 블루"
                );

            case "beige":
                return List.of(
                        "브라운",
                        "화이트",
                        "블랙",
                        "올리브"
                );

            default:
                return List.of();
        }
    }
}
