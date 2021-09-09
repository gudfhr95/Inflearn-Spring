package jpabook.jpashop.service.query;

import static java.util.stream.Collectors.toList;

import java.util.List;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderQueryService {

  private final OrderRepository orderRepository;

  public List<OrderDto> ordersV3() {
    List<Order> orders = orderRepository.findAllWithItem();

    List<OrderDto> result = orders.stream()
        .map(o -> new OrderDto(o))
        .collect(toList());

    return result;
  }
}
