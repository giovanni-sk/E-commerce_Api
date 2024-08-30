package bj.highfiveuniversity.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bj.highfiveuniversity.ecommerce.models.OrderItem;

/**
 * OrderItemRepository
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

               
}