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
public class Order {
               @Id
               @GeneratedValue
               private Long id;
               // TODO: créer la clé secondaire "user_id"

               private Double totalAmount;
               private String status;
               private LocalDateTime updatedAt;
               private LocalDateTime createdAt;
}
