package com.example.myergedd.bean;

import java.util.List;

public class SearchSeeHotBean {
    private List<String> keywords;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "SearchSeeHotBean{" +
                "keywords=" + keywords +
                '}';
    }
}
