package study.datajpa.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item implements Persistable<String> {

  @Id
  private String id;

  @CreatedDate
  private LocalDateTime createdDate;

  public Item(String id) {
    this.id = id;
  }

  @Override
  public String getId() {
    return null;
  }

  @Override
  public boolean isNew() {
    return createdDate == null;
  }
}
