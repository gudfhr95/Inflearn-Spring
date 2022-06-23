package jpabook.jpashop.service.query;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.util.List;
import jpabook.jpashop.domain.*;
import lombok.Getter;

@Getter
public class OrderDto {

  private Long orderId;
  private String name;
  private LocalDateTime orderDate;
  private OrderStatus orderStatus;
  private Address address;
  private List<OrderItemDto> orderItems;

  public OrderDto(Order order) {
    orderId = order.getId();
    name = order.getMember().getName();
    orderDate = order.getOrderDate();
    orderStatus = order.getStatus();
    address = order.getDelivery().getAddress();
    orderItems = order.getOrderItems().stream()
        .map(orderItem -> new OrderItemDto(orderItem))
        .collect(toList());
  }
}
