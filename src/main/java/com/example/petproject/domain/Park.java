package com.example.petproject.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Park {
  private Long id;
  private String name;
  private String parkType;
  private LocalDate foundingDate;
  private int square;
  private String cityName;
  private int employeesNumber;

  public Park() {
  }

  public Park(Long id, String name, String parkType, LocalDate foundingDate, int square, String cityName, int employeesNumber) {
    this.id = id;
    this.name = name;
    this.parkType = parkType;
    this.foundingDate = foundingDate;
    this.square = square;
    this.cityName = cityName;
    this.employeesNumber = employeesNumber;
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
    Park park = (Park) o;
    return square == park.square && employeesNumber == park.employeesNumber && id.equals(park.id) && Objects.equals(name, park.name) && Objects.equals(parkType, park.parkType) && Objects.equals(foundingDate, park.foundingDate) && Objects.equals(cityName, park.cityName);
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


