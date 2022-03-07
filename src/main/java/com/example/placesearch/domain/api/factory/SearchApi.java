package com.example.placesearch.domain.api.factory;

import java.util.HashSet;

public abstract class SearchApi {

    public enum of { KAKAO, NAVER }

    public abstract HashSet<String> requestSearch(String keyword);

}
