package com.example.petproject.repositories;

import com.example.petproject.domain.Park;

import java.util.Optional;

public interface ParkRepository extends Paginated<Park> {

  Optional<Park> getById(Long id);

  Optional<Park> create(Park park);

  Optional<Park> update(Long id, Park park);

  void delete(Long id);
}
