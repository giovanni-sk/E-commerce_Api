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
@Table(name="products")
public class Product {
               @Id
               @GeneratedValue
         private Long id;   
         @Column(nullable = false)   
         private String name;      

         @Column(columnDefinition = "TEXT")   
         private String description;      

         @Column(nullable = false)   
         private Double price;     
         
         @Column(nullable = false, name="stock_quantity")   
         private Integer stockQty; 

         @Column(updatable  = false)     
         private LocalDateTime createdAt;   
            
         private LocalDateTime updatedAt;      
}
