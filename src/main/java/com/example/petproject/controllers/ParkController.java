package com.example.petproject.controllers;

import com.example.petproject.service.ParkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkController {
    private final ParkService parkService;
    public ParkController(ParkService parkService){
       this.parkService = parkService;
    }
    GetMapping(value = "/{id}")
        public PartDTO getPark(@PathVariable long id){
            return ParkService.get(id);
        }
}
