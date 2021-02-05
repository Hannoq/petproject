package com.example.petproject.dto;

import com.example.petproject.domain.Service;

import java.util.Objects;

public class ServiceDTO {
  private Long id;
  private String name;
  private double service_cost;
  private boolean availableForKids;

  public ServiceDTO() {
  }

  public ServiceDTO(Long id, String name, double service_cost, boolean availableForKids) {
    this.id = id;
    this.name = name;
    this.service_cost = service_cost;
    this.availableForKids = availableForKids;
  }

  public static Service convertToDomain(ServiceDTO serviceDTO) {
    return new Service(serviceDTO.getId(), serviceDTO.getName(), serviceDTO.getService_cost(), serviceDTO.isAvailableForKids());
  }

  public static ServiceDTO convertToDTO(Service createdService) {
    return new ServiceDTO(createdService.getId(), createdService.getName(), createdService.getService_cost(), createdService.isChild_friendly());
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

  public double getService_cost() {
    return service_cost;
  }

  public void setService_cost(double service_cost) {
    this.service_cost = service_cost;
  }

  public boolean isAvailableForKids() {
    return availableForKids;
  }

  public void setAvailableForKids(boolean availableForKids) {
    this.availableForKids = availableForKids;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ServiceDTO serviceDTO = (ServiceDTO) o;
    return Double.compare(serviceDTO.service_cost, service_cost) == 0 && availableForKids == serviceDTO.availableForKids && id.equals(serviceDTO.id) && Objects.equals(name, serviceDTO.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, service_cost, availableForKids);
  }

  @Override
  public String toString() {
    return "Service{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + service_cost +
            ", availableForKids=" + availableForKids +
            '}';
  }
}
