package com.example.petproject.service;

import com.example.petproject.domain.Park;
import com.example.petproject.dto.ParkDTO;
import com.example.petproject.exeptions.ResourceNotFoundException;
import com.example.petproject.repositories.ParkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


@Component
@RequiredArgsConstructor
@Slf4j
public class ParkService {

  private final ParkRepository parkRepository;

  public ParkService(ParkRepository parkRepository) {
    this.parkRepository = parkRepository;
  }

  public ParkDTO create(ParkDTO parkDto) {

    var createdPark = parkRepository.create(ParkDTO.convertToDomain(parkDto)).get();
    var convertDtoPark = ParkDTO.convertToDTO(createdPark);
    return convertDtoPark;
  }

  public ParkDTO get(Long id){
    Park park = parkRepository.getById(id).orElseThrow(() -> new ResourceNotFoundException("Park id with " + " is not found"));
    ParkDTO parkDTO = ParkDTO.convertToDTO(park);
    return parkDTO;
  }

  @Transactional
  public void delete(Long id) {
    parkRepository.getById(id).ifPresentOrElse(park -> {
      parkRepository.delete(id);
    }, () -> {
      throw new ResourceNotFoundException("Park id with id " + id + " is not found");
    });
  }

  @Transactional
  @Override
  public ParkDTO update(Long parkDtoId, ParkDTO retrievedParkDTO) {
    Optional<Park> updatedPark = parkRepository.update(parkDtoId, ParkDTO.convertToDomain(retrievedParkDTO));
    LOGGER.info("{} with id {}  was updated", retrievedParkDTO, parkDtoId);
    return ParkDTO.convertToDTO(updatedPark.orElseThrow(() -> {
     throw new ResourceNotFoundException("Park with id " + parkDtoId + " is not found");
    }));
  }



}
