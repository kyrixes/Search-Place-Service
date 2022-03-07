package com.example.placesearch.domain.api.searchApi;

import com.example.placesearch.domain.api.factory.SearchApi;
import com.example.placesearch.dto.naver.NaverResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashSet;

@Component
public class NaverSearchApi extends SearchApi {

    private final RestTemplate restTemplate;
    private final HashSet<String> searchResult;

    private static final String NAVER_HOST = "https://openapi.naver.com";
    private static final String NAVER_PATH = "/v1/search/local.json";
    private static final String HTML_TAG_PATTERN = "<(/)?([a-zA-Z]*)(\\s[azA-Z]*=[^>]*)?(\\s)*(/)?>";
    private static final String MAX_ELEMENT_SIZE = "5";

    private static String naverId;
    private static String naverSecret;

    @Value("${naverid}")
    public void setNaverId(String value) {
        this.naverId = value;
    }

    @Value("${naversecret}")
    public void setNaverSecret(String value) {
        this.naverSecret = value;
    }

    public NaverSearchApi() {
        this.restTemplate = new RestTemplate();
        this.searchResult = new HashSet<>();
    }

    @Override
    public HashSet<String> requestSearch(String keyword) {
        UriComponents naverUriComponents = UriComponentsBuilder
                .fromUriString(NAVER_HOST)
                .path(NAVER_PATH)
                .queryParam("query", keyword)
                .queryParam("display", MAX_ELEMENT_SIZE)
                .build();

        RequestEntity requestEntity = RequestEntity
                .get(naverUriComponents.toUriString())
                .header("X-Naver-Client-Id", naverId)
                .header("X-Naver-Client-Secret", naverSecret)
                .build();

        ResponseEntity<NaverResponse> naverResponse = restTemplate.exchange(requestEntity, NaverResponse.class);

        naverResponse.getBody().getItems().forEach(p -> searchResult.add(p.getTitle().replaceAll(HTML_TAG_PATTERN,"")));

        return searchResult;
    }
}
