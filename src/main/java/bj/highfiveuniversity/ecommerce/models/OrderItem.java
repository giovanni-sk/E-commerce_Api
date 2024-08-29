package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
