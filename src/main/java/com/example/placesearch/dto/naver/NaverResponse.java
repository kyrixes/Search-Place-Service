package com.example.placesearch.dto.naver;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NaverResponse {

    @JsonProperty("rss")
    private String rss;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("lastBuildDate")
    private String lastBuildDate;

    @JsonProperty("total")
    private int total;

    @JsonProperty("start")
    private int start;

    @JsonProperty("display")
    private int display;

    @JsonProperty("category")
    private String category;

    @JsonProperty("items")
    private List<NaverItems> items;

}
