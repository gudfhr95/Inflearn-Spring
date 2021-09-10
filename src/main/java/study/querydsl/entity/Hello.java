package study.querydsl.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hello {

  @Id
  @GeneratedValue
  private Long id;
}
