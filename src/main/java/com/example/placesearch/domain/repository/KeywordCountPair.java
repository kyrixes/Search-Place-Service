package com.example.placesearch.domain.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class KeywordCountPair {

    private String keyword;
    private long count;
}
