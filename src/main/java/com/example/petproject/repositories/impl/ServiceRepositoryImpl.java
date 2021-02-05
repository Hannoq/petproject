package com.example.petproject.repositories.impl;

import com.example.petproject.domain.Service;
import com.example.petproject.domain.Service;
import com.example.petproject.repositories.ServiceRepository;
import com.example.petproject.repositories.ServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceRepositoryImpl implements ServiceRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(ParkRepositoryImpl.class);
  private static final BeanPropertyRowMapper<Service> SERVICE_BEAN_PROPERTY_ROW_MAPPER = new BeanPropertyRowMapper<Service>(Service.class);

  private final JdbcTemplate jdbcTemplate;

  public ServiceRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Optional<Service> getOne(Long id) {
    try {
      var service = jdbcTemplate.queryForObject("select * from parks where id = ?",
              SERVICE_BEAN_PROPERTY_ROW_MAPPER, id);
      return Optional.of(service);
    } catch (EmptyResultDataAccessException e) {
      LOGGER.debug("EmptyResultDataAccessException: ", e);
      return Optional.empty();
    }
  }

  @Override
  public Optional<Service> create(Service service) {
    LOGGER.debug("creating new Kitty with properties {}", service);
    LOGGER.info("creating new service");
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps =
            connection.prepareStatement("insert into service(name, service_cost) values (?, ?)",
                  new String[] { "id" });
      ps.setString(1, service.getName());
      ps.setDouble(2, service.getService_cost());
      return ps;
    }, keyHolder);
    long serviceId = keyHolder.getKey().longValue();
    return getOne(serviceId);
  }

  @Override
  public Optional<Service> update(Long id, Service service) {
    jdbcTemplate.update("update parks set name = ?, "
                + "service_cost = ?, "
                + "where id = ?",
            service.getName(), service.getService_cost(), id);
    return getOne(id);
  }

  @Override
  public void delete(Long id) {
    jdbcTemplate.update("DELETE FROM services where id = ?", id);
  }

  @Override
  public List<Service> getPaginatedData(int pageNumber, int pageSize) {
    return Collections.emptyList();
  }

}
