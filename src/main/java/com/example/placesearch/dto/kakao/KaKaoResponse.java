package com.example.placesearch.dto.kakao;

import lombok.Data;

import java.util.List;

@Data
public class KaKaoResponse {

    private KakaoMeta meta;
    private List<KaKaoDocument> documents;

}
