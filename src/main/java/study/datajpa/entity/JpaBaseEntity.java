package study.datajpa.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Getter;

@MappedSuperclass
@Getter
public class JpaBaseEntity {

  @Column(updatable = false)
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  @PrePersist
  public void prePersist() {
    LocalDateTime now = LocalDateTime.now();
    createdDate = now;
    updatedDate = now;
  }

  @PreUpdate
  public void preUpdate() {
    updatedDate = LocalDateTime.now();
  }
}
