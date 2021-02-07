package com.example.petproject.service;

import com.example.petproject.domain.Park;
import com.example.petproject.domain.Service;
import com.example.petproject.dto.ParkDTO;
import com.example.petproject.dto.ServiceDTO;
import com.example.petproject.exeptions.ResourceNotFoundException;
import com.example.petproject.repositories.ParkRepository;
import com.example.petproject.repositories.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


    @Component
    @RequiredArgsConstructor
    @Slf4j
    public class ServService {

        private final ServiceRepository serviceRepository;

        public ServService(ServiceRepository serviceRepository) {
            this.serviceRepository = serviceRepository;
        }

        public ServiceDTO create(ServiceDTO serviceDTO) {

            var createdService = serviceRepository.create(ServiceDTO.convertToDomain(serviceDTO)).get();
            var convertDtoService = ServiceDTO.convertToDTO(createdService);
            return convertDtoService;
        }

        @Transactional
        public ServiceDTO get(Long id){
            Service service = serviceRepository.getById(id).orElseThrow(() -> new ResourceNotFoundException("Service id with " + " is not found"));
            ServiceDTO serviceDTO = ServiceDTO.convertToDTO(service);
            return serviceDTO;
        }

        @Transactional
        public void delete(Long id) {
            serviceRepository.getById(id).ifPresentOrElse(service -> {
                serviceRepository.delete(id);
            }, () -> {
                throw new ResourceNotFoundException("Service id with id " + id + " is not found");
            });
        }

        @Transactional
        @Override
        public ServiceDTO update(Long serviceDtoId, ServiceDTO retrievedServiceDTO) {
            Optional<Service> updatedService = serviceRepository.update(serviceDtoId, ServiceDTO.convertToDomain(retrievedServiceDTO));
            LOGGER.info("{} with id {}  was updated", retrievedServiceDTO, serviceDtoId);
            return ServiceDTO.convertToDTO(updatedService.orElseThrow(() -> {
                throw new ResourceNotFoundException("Service with id " + serviceDtoId + " is not found");
            }));
        }


    }
