package com.sparta.outsourcing.domain.order.repository;

import static com.sparta.outsourcing.global.exception.CustomError.NOT_EXIST_ORDER;

import com.sparta.outsourcing.domain.basket.model.Basket;
import com.sparta.outsourcing.domain.order.model.OrderType;
import com.sparta.outsourcing.domain.order.model.entity.OrderDetailsEntity;
import com.sparta.outsourcing.domain.order.model.entity.OrderEntity;
import com.sparta.outsourcing.global.exception.CustomException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

  private final OrderJpaRepository orderJpaRepository;
  private final OrderDetailsJpaRepository orderDetailsJpaRepository;

  @Override
  public Long registerOrder(Long memberId, Long restaurantId) {
    OrderEntity orderEntity = OrderEntity.of(memberId, restaurantId, OrderType.WAITING);
    orderJpaRepository.save(orderEntity);

    return orderEntity.getId();
  }

  @Override
  public void registerOrderDetails(Long orderId, List<Basket> basketList) {
    basketList.forEach(
        menuInfoDto -> {
          OrderDetailsEntity orderDetailsEntity =
              OrderDetailsEntity.of(orderId, menuInfoDto.getMenuId(), menuInfoDto.getCount());

          orderDetailsJpaRepository.save(orderDetailsEntity);
        }
    );
  }

  @Override
  public OrderEntity findByOrderId(Long orderId) {
    return orderJpaRepository.findById(orderId).orElseThrow(
        () -> new CustomException(NOT_EXIST_ORDER)
    );
  }

  @Override
  public List<OrderDetailsEntity> findOrderDetailsByOrderId(Long orderId) {
    return orderDetailsJpaRepository.findOrderDetailsEntitiesByOrderId(orderId);
  }

  @Override
  public void deleteOrderAll(Long orderId) {
    OrderEntity orderEntity = findByOrderId(orderId);
    List<OrderDetailsEntity> orderDetailsEntityList = findOrderDetailsByOrderId(orderId);

    orderJpaRepository.delete(orderEntity);
    orderDetailsJpaRepository.deleteAll(orderDetailsEntityList);
  }

  @Override
  public void updatedCancel(Long orderId) {
    OrderEntity orderEntity = findByOrderId(orderId);
    orderEntity.updateCancel();
    orderJpaRepository.saveAndFlush(orderEntity);
  }

  @Override
  public List<OrderEntity> findAll() {
    return orderJpaRepository.findAll();
  }
}
