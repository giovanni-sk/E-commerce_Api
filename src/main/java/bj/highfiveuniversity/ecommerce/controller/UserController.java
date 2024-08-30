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
import bj.highfiveuniversity.ecommerce.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {

               @Autowired
               private UserService userService;

               @GetMapping
               public List<User> getAllUsers() {
                              return userService.getAllUsers();
               }

               @GetMapping("/{id}")
               public ResponseEntity<User> getUserById(@PathVariable Long id) {
                              User user = userService.getUserById(id);
                              return ResponseEntity.ok(user);
               }

               @PostMapping
               public ResponseEntity<User> createUser(@RequestBody User user) {
                              User newUser = userService.createUser(user);
                              return ResponseEntity.ok(newUser);
               }

               @PutMapping("/{id}")
               public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestParam User user) {
                              User userToUpdate = userService.updateUser(id, user);

                              return ResponseEntity.ok(userToUpdate);
               }

               @DeleteMapping("/{id}")
               public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
                              userService.deleteUser(id);
                              return ResponseEntity.noContent().build();
               }

}
