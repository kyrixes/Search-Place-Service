package com.example.placesearch.controller;

import com.example.placesearch.common.ServerResponse;

import com.example.placesearch.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrendController {

    @Autowired
    private TrendService trendService;

    @GetMapping("/trends")
    public ResponseEntity inquireTrends() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(ServerResponse.rsp(trendService.getTrends()));
    }

}
