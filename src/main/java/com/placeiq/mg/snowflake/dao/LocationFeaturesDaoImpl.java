package com.placeiq.mg.snowflake.dao;

import com.placeiq.commons.geo.swig.Tile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by miralgadani on 5/30/15.
 */
@Repository
public class LocationFeaturesDaoImpl implements LocationFeaturesDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Inject
    public LocationFeaturesDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String findOne(String identifier) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", identifier);
        return jdbcTemplate.queryForObject("select entry\\:id from location_features where entry\\:id.identifier=:id", params, String.class);
    }

    public List<String> findByFacet(String facet) {
        return null;
    }

    public Long count() {
        return jdbcTemplate.queryForObject("select count(*) from location_features",(Map) null, Long.class);
    }

    public List<String> getFeaturesForTiles(List<Tile> tiles) {
        Set<String> tileIds = new HashSet<String>();
        for (Tile tile : tiles) {
            tileIds.add(tile.getLabel());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("tileIds", tileIds);
        return jdbcTemplate.queryForList("select entry from location_features where entry\\:geoid in (:tileIds)", params, String.class);
    }
}
