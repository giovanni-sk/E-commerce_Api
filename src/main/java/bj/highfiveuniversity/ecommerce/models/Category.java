package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "categories")
public class Category {
               @Id
               @GeneratedValue
               private Long Id;

               @Column(nullable = false)
               private String name;
               @ManyToMany(mappedBy = "categories")
               private List<Product> products;

               @Column(nullable = false, updatable  = false)     
               private LocalDateTime createdAt;   
                  
               private LocalDateTime updatedAt;    


               @PrePersist
               protected void onCreate() {
                              createdAt = LocalDateTime.now();
                              updatedAt = LocalDateTime.now();
               }

               @PreUpdate
               protected void onUpdate() {
                              updatedAt = LocalDateTime.now();
               }
               
}