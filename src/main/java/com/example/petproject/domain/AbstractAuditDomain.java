package com.example.petproject.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Setter
@Getter
@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public abstract class AbstractAuditDomain {
  @CreatedDate
  @Column(name = "created_date")
  private Instant createdDate;

  @LastModifiedDate
  private Instant modifiedDate;

  @CreatedBy
  private String createdBy;

  @LastModifiedBy
  private String modifiedBy;
}
