package com.example.petproject.controllers;

import com.example.petproject.dto.ParkDTO;
import com.example.petproject.service.ParkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/parks")
public class ParkController {
//    private final ParkService parkService;
//    public ParkController(ParkService parkService){
//       this.parkService = parkService;
//    }
//    GetMapping(value = "/{id}")
//        public PartDTO getPark(@PathVariable long id){
//            return ParkService.get(id);
//        }

        private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ParkDTO create(@RequestBody ParkDTO parkDTO) {
//        return ParkService.create(parkDTO);
//    }

    @PostMapping
    public ResponseEntity<ParkDTO> create(@RequestBody ParkDTO parkDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ParkService.create(parkDTO));
    }

//    @GetMapping
//    public List<ParkDTO> getParks(
//            @RequestParam(required = false) String text,
//            @RequestParam(required = false) String sortField
//    ) {
//        return parkService.findAll(text, sortField);
//    }


    @GetMapping(path = "/{id}")
    public ParkDTO get(@PathVariable Long id) {
        return parkService.get(id);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        parkService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public ParkDTO update(@PathVariable Long id, @RequestBody ParkDTO parkDTO) {
        return parkService.update(id, parkDTO);
    }

}
