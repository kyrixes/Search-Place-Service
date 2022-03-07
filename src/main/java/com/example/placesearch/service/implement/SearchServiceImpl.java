package com.example.placesearch.service.implement;

import com.example.placesearch.domain.repository.PlaceRedis;
import com.example.placesearch.domain.repository.PlaceRedisRepository;
import com.example.placesearch.domain.api.factory.SearchApi;
import com.example.placesearch.domain.api.factory.SearchApiFactory;
import com.example.placesearch.domain.api.factory.Factory;
import com.example.placesearch.service.SearchService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private PlaceRedisRepository placeRedisRepository;

    /**
     * 검색어를 입력받아 각 API별로 검색을 요청하고 결과를 응답하는 서비스입니다
     *
     *  - 컨트롤러로부터 검색어를 받아 검색 내역에 저장
     *  - API 팩토리 생성 후 검색 요청
     *  - 응답결과 처리 후 컨트롤러로 응답
     *
     */
    @Override
    @CircuitBreaker(name = "search", fallbackMethod = "fallback")
    public List<String> searchPlace(String keyword) {

        saveKeywordHistory(keyword);

        Factory searchApiFactory = new SearchApiFactory();

        return makeSearchResult(
                searchApiFactory.create(SearchApi.of.KAKAO).requestSearch(keyword),
                searchApiFactory.create(SearchApi.of.NAVER).requestSearch(keyword)
        );
    }

//    @Cacheable(cacheNames = "redis_cache")
    public void saveKeywordHistory(String keyword) {
        placeRedisRepository.save(new PlaceRedis(keyword, LocalDateTime.now()));
    }


    /**
     * 카카오와 네이버 장소검색 API로부터 각각 응답받은 결과를 처리하는 메소드입니다
     *  1. 카카오의 검색결과 기준, 네이버 동일 검색결과 존재시 결과 리스트 상위에 위치
     *  2. 각 결과에서 일치 항목을 remove
     *  3. 나머지 결과를 카카오 -> 네이버 순으로 addAll
     */
    public List<String> makeSearchResult(HashSet<String> kakaoSearchResult, HashSet<String> naverSearchResult) {

        List<String> searchResult = new ArrayList<>();

        naverSearchResult.forEach (plc -> {
            if (kakaoSearchResult.contains(plc))
                searchResult.add(plc);
        });

        searchResult.forEach (plc -> {
            kakaoSearchResult.remove(plc);
            naverSearchResult.remove(plc);
        });

        searchResult.addAll(kakaoSearchResult);
        searchResult.addAll(naverSearchResult);

        return searchResult;
    }

    /**
     * CircuitBreaker Fallback 메소드
     *  - 서비스 정책에 따른 프로세스를 구현합니다.
     */
    public List<String> fallback(String keyword, Throwable t) {
        return null;
    }

}
