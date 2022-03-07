package com.example.placesearch.domain.api.factory;

import com.example.placesearch.domain.api.searchApi.KakaoSearchApi;
import com.example.placesearch.domain.api.searchApi.NaverSearchApi;

public class SearchApiFactory extends Factory {

    @Override
    public SearchApi create(SearchApi.of api) {
        switch (api) {
            case KAKAO:
                return new KakaoSearchApi();
            case NAVER:
                return new NaverSearchApi();
        }
        return null;
    }
}
