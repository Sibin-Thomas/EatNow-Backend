package com.spe.eatnow_backend.requestBodies;b

public class SearchRestaurantRequestBody {
    String searchValue;

    public SearchRestaurantRequestBody() {
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
