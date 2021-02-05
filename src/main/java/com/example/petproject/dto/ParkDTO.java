package com.example.petproject.dto;

import com.example.petproject.domain.Park;

import java.time.LocalDate;
import java.util.Objects;

public class ParkDTO {
  private Long id;
  private String name;
  private String parkType;
  private LocalDate foundingDate;
  private int square;
  private String cityName;
  private int employeesNumber;

  public ParkDTO() {
  }

  public ParkDTO(Long id, String name, String parkType, LocalDate foundingDate, int square, String cityName, int employeesNumber) {
    this.id = id;
    this.name = name;
    this.parkType = parkType;
    this.foundingDate = foundingDate;
    this.square = square;
    this.cityName = cityName;
    this.employeesNumber = employeesNumber;
  }

  public static Park convertToDomain(ParkDTO parkDTO) {
    return new Park(parkDTO.getId(), parkDTO.getName(), parkDTO.getParkType(), parkDTO.getFoundingDate(), parkDTO.getSquare(), parkDTO.getCityName(), parkDTO.getEmployeesNumber());
  }

  public static ParkDTO convertToDTO(Park createdPark) {
    return new ParkDTO(createdPark.getId(), createdPark.getName(), createdPark.getParkType(), createdPark.getFoundingDate(), createdPark.getSquare(), createdPark.getCityName(), createdPark.getEmployeesNumber());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParkType() {
    return parkType;
  }

  public void setParkType(String parkType) {
    this.parkType = parkType;
  }

  public LocalDate getFoundingDate() {
    return foundingDate;
  }

  public void setFoundingDate(LocalDate foundingDate) {
    this.foundingDate = foundingDate;
  }

  public int getSquare() {
    return square;
  }

  public void setSquare(int square) {
    this.square = square;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public int getEmployeesNumber() {
    return employeesNumber;
  }

  public void setEmployeesNumber(int employeesNumber) {
    this.employeesNumber = employeesNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ParkDTO parkDTO = (ParkDTO) o;
    return square == parkDTO.square && employeesNumber == parkDTO.employeesNumber && id.equals(parkDTO.id) && Objects.equals(name, parkDTO.name) && Objects.equals(parkType, parkDTO.parkType) && Objects.equals(foundingDate, parkDTO.foundingDate) && Objects.equals(cityName, parkDTO.cityName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, parkType, foundingDate, square, cityName, employeesNumber);
  }

  @Override
  public String toString() {
    return "Park{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", parkType='" + parkType + '\'' +
            ", foundingDate=" + foundingDate +
            ", square=" + square +
            ", cityName='" + cityName + '\'' +
            ", employeesNumber=" + employeesNumber +
            '}';
  }
}


