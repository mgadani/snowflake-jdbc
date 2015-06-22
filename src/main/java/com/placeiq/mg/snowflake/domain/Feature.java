package com.placeiq.mg.snowflake.domain;

/**
 * Created by miralgadani on 6/1/15.
 */
public class Feature {

    private final String id;

    private final String title;

    private final String category;

    private final String geometry;


    public Feature(String id, String title, String category, String geometry) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.geometry = geometry;
    }
}
