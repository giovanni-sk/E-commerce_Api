package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/* 
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
*/
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
               @Id
               @GeneratedValue //id generé automatiquement
               private Long id;
              
               @Column(nullable = false, unique = true)
               private String username;

               @Column(nullable = false, unique = true)
               private String email;

               @Column(nullable = false)
               private String password;

               @Column(nullable = false, updatable  = false)
               private LocalDateTime createdAt;

               private LocalDateTime updatedAt;

               @OneToMany(mappedBy = "user")
               private List <Order> orders;


               
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