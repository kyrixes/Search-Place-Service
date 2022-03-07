package com.example.placesearch.dto.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoMeta {

    /**
     * total_count
     * pageable_count
     * is_end
     * same_name
     *  region
     *  keyword
     *  selected_region
     */
    @JsonProperty("total_count")
    private int totalCount;

    @JsonProperty("pageable_count")
    private int pageableCount;

    @JsonProperty("is_end")
    private boolean isEnd;

    @JsonProperty("same_name")
    private KakaoSameName kakaoSameName;
}
