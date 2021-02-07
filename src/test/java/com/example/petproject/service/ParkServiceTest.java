package com.example.petproject.service;

import com.example.petproject.domain.Park;
import com.example.petproject.dto.ParkDTO;
import com.example.petproject.repositories.ParkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.*;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;


public class ParkServiceTest {


    private List<Park> parks;
    private List<ParkDTO> parkDTO;
    @InjectMocks
    private ParkService parkService;

    @Mock
    private ParkRepository parkRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);


        Park parkVolna = new Park(11l, "Volna", "Aquapark",
                LocalDate.of(2007, 7, 8), 22000, "Kharkiv", 100);
        parks.add(parkVolna);

        parks = new ArrayList<>();
        Park parkGorkogo = new Park();
        String name = "Park Gorkogo";
        String parkType = "Central Park";
        LocalDate foundationDate = LocalDate.of(1893, 2, 3);
        int square = 64000;
        String cityName = "Kharkiv";
        int employeesNumber = 500;

        parkGorkogo.setName(name);
        parkGorkogo.setParkType(parkType);
        parkGorkogo.setFoundingDate(foundationDate);
        parkGorkogo.setSquare(square);
        parkGorkogo.setCityName(cityName);
        parkGorkogo.setEmployeesNumber(employeesNumber);
        parks.add(parkGorkogo);


        ParkDTO parkDTOGorkogo = ParkDTO.convertToDTO(parkGorkogo);
        ParkDTO parkDTOVolna = ParkDTO.convertToDTO(parkVolna);
        parkDTO = new ArrayList<>();

        parkDTO.add(parkDTOGorkogo);
        parkDTO.add(parkDTOVolna);



        }
    @Test
    void getByIdPark_shouldReturnPark() {
        Long parkResult = 3l;
        ParkDTO parkDTO = ParkDTO.convertToDTO(parks.get(0));
        Park park = ParkDTO.convertToDomain(parkDTO);

        when(parkRepository.getById(parkResult)).thenReturn(of(park));

        ParkDTO parkCheck = parkService.getById(parkResult);
        verify(parkRepository).getById(parkResult);
        assertEquals("Kharkiv", parkCheck.getCityName());
        assertEquals("Aquapark", parkCheck.getParkType());
        assertEquals(100, parkCheck.getEmployeesNumber());


    }

    @Test
    void deletePark_existedPark_shouldExecuteDeleteMethods() {
        Long parkToDelete = 77L;
        when(parkRepository.getById(parkToDelete)).thenReturn(of(new Park()));

        parkRepository.delete(parkToDelete);

        verify(parkRepository).delete(parkToDelete);
    }

    @Test
    void deletePark_existedPark_shouldThrowResourceNotFoundException() {
        Long parkToDelete = 77L;
        when(parkRepository.getById(parkToDelete)).thenReturn(Optional.empty());

        assertThrows(NullPointerException.class, () -> parkService.delete(parkToDelete));

        verify(parkRepository, never()).delete(parkToDelete);
    }
}
