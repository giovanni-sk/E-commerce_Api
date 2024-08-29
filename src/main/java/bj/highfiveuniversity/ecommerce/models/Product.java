package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
               @Id
               @GeneratedValue
         private Long id;      
         private String name;      
         private String description;      
         private Double price;      
         private Integer stockQty;      
         private LocalDateTime createdAt;      
         private LocalDateTime updatedAt;      
}
