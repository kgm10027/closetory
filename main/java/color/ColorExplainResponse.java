package com.example.closetory.color;

import java.util.List;

public class ColorExplainResponse {
    private String base;
    private List<MatchItem> matches;

    public ColorExplainResponse() {}

    public ColorExplainResponse(String base, List<MatchItem> matches) {
        this.base = base;
        this.matches = matches;
    }

    public String getBase() { return base; }
    public void setBase(String base) { this.base = base; }

    public List<MatchItem> getMatches() { return matches; }
    public void setMatches(List<MatchItem> matches) { this.matches = matches; }
}
