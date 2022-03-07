package com.example.placesearch.domain.api.factory;

public abstract class Factory {

    public final SearchApi search(SearchApi.of api) {
        return this.create(api);
    }

    abstract public SearchApi create(SearchApi.of api);

}
