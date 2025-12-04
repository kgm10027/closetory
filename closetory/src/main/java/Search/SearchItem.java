package com.example.closetory.search;

import java.util.List;

public class SearchItem {
    private String id;          // 고유 ID (home-hero 등)
    private String title;       // 카드/섹션 제목
    private String category;    // 메인, 코디, 상황별, 캘린더 등
    private String description; // 짧은 설명
    private String url;         // 이동할 페이지 (ex. /index.html)
    private List<String> keywords; // 검색용 키워드들

    public SearchItem(String id, String title, String category,
                      String description, String url, List<String> keywords) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.url = url;
        this.keywords = keywords;
    }

    // 기본 생성자 + getter만 있으면 됨 (setter는 선택)
    public SearchItem() {}

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getUrl() { return url; }
    public List<String> getKeywords() { return keywords; }
}