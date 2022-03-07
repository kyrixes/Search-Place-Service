package com.example.placesearch.dto.naver;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NaverItems {

    @JsonProperty("title")
    private String title;

    @JsonProperty("link")
    private String link;

    @JsonProperty("category")
    private String category;

    @JsonProperty("description")
    private String description;

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("address")
    private String address;

    @JsonProperty("roadAddress")
    private String roadAddress;

    @JsonProperty("mapx")
    private int mapx;

    @JsonProperty("mapy")
    private int mapy;

}
