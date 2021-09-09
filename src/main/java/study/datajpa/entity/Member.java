package study.datajpa.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue
  private Long id;
  private String username;

  protected Member() {
  }

  public Member(String username) {
    this.username = username;
  }
}
