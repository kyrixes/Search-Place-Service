package com.example.placesearch.domain.api.searchApi;

import com.example.placesearch.domain.api.factory.SearchApi;
import com.example.placesearch.dto.kakao.KaKaoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class KakaoSearchApi extends SearchApi {

    private RestTemplate restTemplate;
    private HashSet<String> searchResult;

    private static final String KAKAO_HOST = "https://dapi.kakao.com";
    private static final String KAKAO_PATH = "/v2/local/search/keyword.json";
    private static final String MAX_ELEMENT_SIZE = "5";

    private static String kakaoKey;

    @Value("${kakaokey}")
    public void setKakaoKey(String value) {
        this.kakaoKey = value;
    }

    public KakaoSearchApi() {
        this.restTemplate = new RestTemplate();
        this.searchResult = new HashSet<>();
    }

    @Override
    public HashSet<String> requestSearch(String keyword) {
        UriComponents kakaoUriComponents = UriComponentsBuilder
                .fromUriString(KAKAO_HOST)
                .path(KAKAO_PATH)
                .queryParam("query", keyword)
                .queryParam("size", MAX_ELEMENT_SIZE)
                .build();

        RequestEntity requestEntity = RequestEntity
                .get(kakaoUriComponents.toUriString())
                .header("Authorization", "KakaoAK" + " " + kakaoKey)
                .build();

        ResponseEntity<KaKaoResponse> kakaoResponse = restTemplate.exchange(requestEntity, KaKaoResponse.class);

        kakaoResponse.getBody().getDocuments().forEach(p -> searchResult.add(p.getPlaceName()));

        return searchResult;
    }
}
