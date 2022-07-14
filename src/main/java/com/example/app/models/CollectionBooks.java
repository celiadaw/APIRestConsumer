package com.example.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;


public class Collection implements Serializable {

    private static final long serialVersionUID = 32394793429342394L;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("totalItems")
    private Long totalItems;

    @JsonProperty("items")
    private String[] items;

    public Collection() {

    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "kind='" + kind + '\'' +
                ", totalItems=" + totalItems +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
