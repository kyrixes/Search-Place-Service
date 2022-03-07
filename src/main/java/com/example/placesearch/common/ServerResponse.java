package com.example.placesearch.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ServerResponse<T> {

    private LocalDateTime timeStamp;
    private String message;
    private T data;

    public ServerResponse(final int code, final String message) {
        this.message = message;
        this.data = null;
    }

    public static<T> ServerResponse<T> rsp(final T data) {
        return rsp("", data);
    }

    public static<T> ServerResponse<T> rsp(final String message) {
        return rsp(message, null);
    }

    public static<T> ServerResponse<T> rsp(final String message, final T data) {
        return ServerResponse.<T>builder()
                .timeStamp(LocalDateTime.now())
                .data(data)
                .message(message)
                .build();
    }

}
