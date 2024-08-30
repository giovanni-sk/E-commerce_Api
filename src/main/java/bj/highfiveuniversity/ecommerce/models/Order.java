package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
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
               @ManyToOne()
               @JoinColumn(name = "user_id" , nullable = false)
               private User user;

               @Column(nullable = false)
               private Double totalAmount;

               @Column(nullable = false)
               private String status;


               @Column(nullable = false, updatable  = false)
               private LocalDateTime updatedAt;

               private LocalDateTime createdAt;

               @OneToMany(mappedBy = "order")
               private List<OrderItem> orderItems;


               
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
