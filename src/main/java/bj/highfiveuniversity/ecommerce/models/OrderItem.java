package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {
               @Id
               @GeneratedValue
               private Long id;
               // TODO: creer la clé secondaire "order_id"
               // TODO: créer la clé secondaire "product_id"
               @Column(nullable = false)
               private Integer quantity;

               @Column(nullable = false)
               private Double price;

               @Column(updatable = false)
               private LocalDateTime createdAt;

               private LocalDateTime updatedAt;
}
