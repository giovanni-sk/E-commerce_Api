package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
               @ManyToOne
               @JoinColumn(name = "order_id", nullable = false)
               private Order order;

               // TODO: créer la clé secondaire "product_id"
               @ManyToOne
               @JoinColumn(name ="product_id" , nullable=false)
               private Product product;
               @Column(nullable = false)
               private Integer quantity;

               @Column(nullable = false)
               private Double price;

               @Column(updatable = false)
               private LocalDateTime createdAt;

               private LocalDateTime updatedAt;
}
