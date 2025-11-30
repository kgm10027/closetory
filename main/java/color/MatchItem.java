package com.example.closetory.color;

public class MatchItem {
    private String color;       // 예: "beige" 또는 "#D6C4A0"
    private String reason;      // 예: "네이비와 베이지는 클래식한 대비로 안정감을 줍니다."

    public MatchItem() {}

    public MatchItem(String color, String reason) {
        this.color = color;
        this.reason = reason;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
