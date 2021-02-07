package com.example.petproject.repositories;

import com.example.petproject.domain.Service;

import java.util.Optional;

public interface ServiceRepository extends Paginated<Service> {
  Optional<Service> get(Long id);

  Optional<Service> create(Service service);

  Optional<Service> update(Long id, Service service);

  void delete(Long id);

};
