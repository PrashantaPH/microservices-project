package com.clientmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginationRequest {

    @JsonProperty("page_size")
    private int pageSize;
    @JsonProperty("page_number")
    private int pageNumber;
    @JsonProperty("sort_by")
    private String sortBy;
    @JsonProperty("sort_direction")
    private String sortDirection;
    @JsonProperty("search_string")
    private String searchString;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
