package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class User {
               @Id
               @GeneratedValue //id generé automatiquement
               private Long id;
               private String username;
               private String email;
               private String password;
               private LocalDateTime createdAt;
               private LocalDateTime updatedAt;
}