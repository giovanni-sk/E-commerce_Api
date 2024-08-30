package bj.highfiveuniversity.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.ecommerce.models.User;
import bj.highfiveuniversity.ecommerce.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {
              @Autowired
              private UserRepository userRepository;
              //Recuperer tout les users
              @GetMapping 
              public List<User> getAllUsers(){
               return userRepository.findAll();
              }
              //Recuperer un User pas son id
              @GetMapping("/{id}")
              public ResponseEntity<User> getUserById(@PathVariable Long id){
                              User user = userRepository
                              .findById(id)
                              .orElseThrow(
                                             ()->new RuntimeException("User non trouvé")
                                             );
                              return ResponseEntity.ok(user);
              }


              //Créer un user

              @PostMapping
              public ResponseEntity<User> createUser(@RequestBody User user){
               User newUser = userRepository.save(user);
               return ResponseEntity.ok(newUser);
              }


              //Modifier 

              @PutMapping("/{id}")
              public ResponseEntity<User> updateUser(@PathVariable Long id , @RequestParam User user){
               User userToUpdate = userRepository
               .findById(id)
               .orElseThrow(
                              ()-> new RuntimeException("User avec l'id"+id+"non trouvé")
                              );

                              userToUpdate.setUsername(user.getUsername());
                              userToUpdate.setEmail(user.getEmail());
                              userToUpdate.setPassword(user.getPassword());
                              return ResponseEntity.ok(userToUpdate);
              }
              //Supprimer

              @DeleteMapping("/{id}")
              public ResponseEntity<Void> deleteUser(@PathVariable Long id  ){
               userRepository.deleteById(id);
               return ResponseEntity.noContent().build();
              }
              
              
}
