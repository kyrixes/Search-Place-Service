package com.example.placesearch.service;

import com.example.placesearch.domain.repository.KeywordCountPair;

import java.util.List;

public interface TrendService {

    List<KeywordCountPair> getTrends() throws Exception;

}
