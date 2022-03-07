package com.example.placesearch.controller;

import com.example.placesearch.common.ServerResponse;
import com.example.placesearch.service.SearchService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("keyword") String keyword) throws Exception {
        if (StringUtils.isEmpty(keyword))
            throw new IllegalArgumentException("검색어를 입력해주세요.");
        return ResponseEntity.status(HttpStatus.OK).body(ServerResponse.rsp(searchService.searchPlace(keyword)));
    }
}
