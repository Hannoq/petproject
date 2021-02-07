package com.example.petproject.controllers;

import com.example.petproject.dto.ParkDTO;
import com.example.petproject.dto.ServiceDTO;
import com.example.petproject.service.ServService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/services")
public class ServiceController {
    private final ServService servService;
    @PostMapping
    public ServiceDTO create(@RequestBody ServiceDTO serviceDTO) {
        return servService.create(serviceDTO);
    }

//    @GetMapping
//    public List<ServiceDTO> getServices(
//            @RequestParam(required = false) String text,
//            @RequestParam(required = false) String sortField
//    ) {
//        return servService.findAll(text, sortField);
//    }
    @GetMapping(path = "/{id}")
    public ServiceDTO get(@PathVariable Long id) {
        return servService.get(id);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        servService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public ServiceDTO update(@PathVariable Long id, @RequestBody ServiceDTO serviceDTO) {
        return servService.update(id, serviceDTO);
    }
}
