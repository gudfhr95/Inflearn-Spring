package hello.springtx.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

  @Id
  @GeneratedValue
  private Long id;

  private String username; // 정상, 예외, 잔고부족
  private String payStatus; // 대기, 완료
}
