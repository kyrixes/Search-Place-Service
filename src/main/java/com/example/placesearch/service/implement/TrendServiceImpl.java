package com.example.placesearch.service.implement;

import com.example.placesearch.domain.repository.KeywordCountPair;
import com.example.placesearch.domain.repository.PlaceRedisRepository;
import com.example.placesearch.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrendServiceImpl implements TrendService {

    @Autowired
    PlaceRedisRepository placesRedisRepository;

    @Override
    public List<KeywordCountPair> getTrends() throws Exception {
        return inquireTrends();
    }

//    @CachePut
    public ArrayList<KeywordCountPair> inquireTrends() {
        return (ArrayList<KeywordCountPair>) placesRedisRepository.findGroupByKeyword();
    }
}
