package com.example.petproject.service;

import com.example.petproject.domain.Park;
import com.example.petproject.dto.ParkDTO;
import com.example.petproject.exeptions.ResourceNotFoundException;
import com.example.petproject.repositories.ParkRepository;
import com.example.petproject.repositories.ServiceRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ParkService {

  private final ParkRepository parkRepository;
  private final ServiceRepository serviceRepository;
//  private final PetClinicClient petClinicClient;

  public ParkService(ParkRepository parkRepository, ServiceRepository serviceRepository) {
    this.parkRepository = parkRepository;
    this.serviceRepository = serviceRepository;
  }

  public ParkDTO createPark(ParkDTO parkDto) {

    var createdPark = parkRepository.create(ParkDTO.convertToDomain(parkDto)).get();
    var convertDtoPark = ParkDTO.convertToDTO(createdPark);
    return convertDtoPark;
  }

  @Transactional
  public void deletePark(Long id) {
    parkRepository.getById(id).ifPresentOrElse(cat -> {
      parkRepository.delete(id);
    }, () -> {
      throw new ResourceNotFoundException("Cat id with id " + id + " is not found");
    });
  }
  public ParkDTO get(Long id){
    Park park = parkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Park id with " + " is not found"));
    ParkDTO parkDTO = ParkDTO.convertToDTO(park);
    return parkDTO;
  }

}
