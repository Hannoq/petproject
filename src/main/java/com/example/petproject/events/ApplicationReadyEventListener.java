package com.example.petproject.events;

import com.example.petproject.domain.Park;
import com.example.petproject.repositories.ParkRepository;
import com.example.petproject.service.ApplicationService;
import com.example.petproject.service.ParkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventListener.class);

  private final ParkRepository parkRepository;
  private final ApplicationService applicationService;
  private final ParkService parkService;

  public ApplicationReadyEventListener(ParkRepository parkRepository,
                                       ApplicationService applicationService,
                                       ParkService parkService) {
    this.parkService = parkService;
    this.parkRepository = parkRepository;
    this.applicationService = applicationService;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void up(){
    parkService.deletePark(42L);
  }



//  @EventListener(ApplicationReadyEvent.class)
  public void applicationReady() {
    LOGGER.info("====== Application is ready =====");
    LOGGER.info("====== Application is name {} =====", applicationService.getName());
//
//    LOGGER.info("Park with id 1: " + parkRepository.getOne(1L)); ??? try again this

    var newPark = parkRepository.create(new Park());
    LOGGER.info("New created park: " + newPark);

    var updatedPark = parkRepository.update(newPark.get().getId(), new Park());
    LOGGER.info("updated park: " + updatedPark);

    LOGGER.info("Deleting park with id: " + updatedPark.get().getId());
    parkRepository.delete(updatedPark.get().getId());

    var deletedPark = parkRepository.getById(updatedPark.get().getId());
    LOGGER.info("Deleted park: " + deletedPark);

    var paginatedParks = parkRepository.getPaginatedData(1, 5);
    LOGGER.info("Paginated parks size: " + paginatedParks.size());
    LOGGER.info("Paginated parks: " + paginatedParks);
  }
}
