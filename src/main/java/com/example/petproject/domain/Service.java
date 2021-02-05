package com.example.petproject.domain;

import java.util.Objects;

public class Service {
  private Long id;
  private String name;
  private double service_cost;
  private boolean child_friendly;

  public Service() {
  }

  public Service(Long id, String name, double service_cost, boolean child_friendly) {
    this.id = id;
    this.name = name;
    this.service_cost = service_cost;
    this.child_friendly = child_friendly;
    //DELETE LINKAGE TO PARKS AND ALL IT'S INSTANCES
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

  public boolean isChild_friendly() {
    return child_friendly;
  }

  public void setChild_friendly(boolean child_friendly) {
    this.child_friendly = child_friendly;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Service service = (Service) o;
    return Double.compare(service.service_cost, service_cost) == 0 && child_friendly == service.child_friendly && id.equals(service.id) && Objects.equals(name, service.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, service_cost, child_friendly);
  }
}
