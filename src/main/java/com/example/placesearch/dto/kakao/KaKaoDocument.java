package com.example.placesearch.dto.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KaKaoDocument {
    @JsonProperty("address_name")
    private String addressName;

    @JsonProperty("category_group_code")
    private String categoryGroupCode;

    @JsonProperty("category_group_name")
    private String categoryGroupName;

    @JsonProperty("category_name")
    private String categoryName;

    @JsonProperty("distance")
    private String distance;

    @JsonProperty("id")
    private String id;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("place_name")
    private String placeName;

    @JsonProperty("place_url")
    private String placeUrl;

    @JsonProperty("road_address_name")
    private String roadAddressName;

    @JsonProperty("x")
    private String x;

    @JsonProperty("y")
    private String y;

//    @JsonProperty("redirect_url")
//    @JsonIgnoreProperties(ignoreUnknown=true)
//    private String redirectUrl;
}
