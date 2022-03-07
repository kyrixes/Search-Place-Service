package com.example.placesearch.dto.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class KakaoSameName {
    /**
     * region
     * keyword
     * selected_region
     */
    @JsonProperty("region")
    private List<String> region;

    @JsonProperty("keyword")
    private String keyword;

    @JsonProperty("selected_region")
    private String selectRegion;
}
