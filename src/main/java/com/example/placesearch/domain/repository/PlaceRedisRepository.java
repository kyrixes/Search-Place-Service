package com.example.placesearch.domain.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRedisRepository  extends JpaRepository<PlaceRedis, Long> {

    /**
     * 인기 검색어 순위를 내림차순으로 정렬합니다
     */
    @Query(value=
            "SELECT new com.example.placesearch.domain.repository.KeywordCountPair(PLC.keyword, COUNT(PLC)) " +
              "FROM PlaceRedis PLC " +
             "GROUP BY PLC.keyword " +
             "ORDER BY COUNT(PLC) DESC"
    )
    List<KeywordCountPair> findGroupByKeyword();

}
