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
@Table(name = "orders")
public class Order {
               @Id
               @GeneratedValue
               private Long id;
               // TODO: créer la clé secondaire "user_id"
               @Column(nullable = false)
               private Double totalAmount;

               @Column(nullable = false)
               private String status;
               
               private LocalDateTime updatedAt;

               @Column(updatable  = false)
               private LocalDateTime createdAt;
}
