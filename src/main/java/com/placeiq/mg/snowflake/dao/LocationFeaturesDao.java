package com.placeiq.mg.snowflake.dao;

import com.placeiq.commons.geo.swig.Tile;
import com.placeiq.mg.snowflake.domain.Feature;

import java.util.List;

/**
 * Created by miralgadani on 5/30/15.
 */
public interface LocationFeaturesDao {
    String findOne(String identifier);

    List<String> findByFacet(String facet);

    Long count();

    List<String> getFeaturesForTiles(List<Tile> tiles);
}
