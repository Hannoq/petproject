package com.example.petproject.repositories.impl;

import com.example.petproject.domain.Park;
import com.example.petproject.repositories.ParkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
public class ParkRepositoryImpl implements ParkRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParkRepositoryImpl.class);
    private static final BeanPropertyRowMapper<Park> PARK_BEAN_PROPERTY_ROW_MAPPER = new BeanPropertyRowMapper<>(Park.class);

    private final String applicationName;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ParkRepositoryImpl(String applicationName,
                             JdbcTemplate jdbcTemplate) {
        this.applicationName = applicationName;
        this.jdbcTemplate = jdbcTemplate;
        LOGGER.info("=============== ParkRepositoryImpl constructor is called =================");
        LOGGER.info("Application name: " + this.applicationName);
    }

    @Override
    public Optional<Park> getById(Long id) {
        try {
            var park = jdbcTemplate.queryForObject("select * from parks where id = ?",
                    PARK_BEAN_PROPERTY_ROW_MAPPER, id);
            return Optional.of(park);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.debug("EmptyResultDataAccessException: ", e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Park> create(Park park) {
        LOGGER.debug("creating new park with properties {}, {}", park, "another info");
        LOGGER.info("creating new park");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("insert into parks(name, city_name, park_type) values (?, ?, ?)",
                            new String[] { "id" });
            ps.setString(1, park.getName());
            ps.setString(2, park.getCityName());
            ps.setString(3, park.getParkType());
            return ps;
        }, keyHolder);
        long parkId = keyHolder.getKey().longValue();
        return getById(parkId);
    }

    @Override
    public Optional<Park> update(Long id, Park park) {
        jdbcTemplate.update("update parks set name = ?, "
                        + "city_name = ?, "
                        + "park_type = ? "
                        + "where id = ?",
                park.getName(), park.getCityName(), park.getParkType(), id);
        return getById(id);
    }

    @Override
    public void delete(Long id) {
        throw  new RuntimeException();
//    jdbcTemplate.update("DELETE FROM parks where id = ?", id);
    }

    @Override
    public List<Park> getPaginatedData(int pageNumber, int pageSize) {
        int limit = pageSize;
        int offset = pageNumber * pageSize;
        return jdbcTemplate.query("select * from parks limit ? offset ?", PARK_BEAN_PROPERTY_ROW_MAPPER, limit, offset);
    }


}
