package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderItem {
               @Id
               @GeneratedValue
               private Long id;
               // TODO: creer la clé secondaire "order_id"
               // TODO: créer la clé secondaire "product_id"

               private Integer quantity;
               private Double price;
               private LocalDateTime createdAt;
               private LocalDateTime updatedAt;
}
