package bj.highfiveuniversity.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.ecommerce.models.User;
import bj.highfiveuniversity.ecommerce.repository.UserRepository;

@Service
public class UserService {
               @Autowired
               UserRepository userRepository;

               public List<User> getAllUsers() {
                              return userRepository.findAll();
               }

               public User getUserById(Long id) {
                              User user = userRepository
                                                            .findById(id)
                                                            .orElseThrow(
                                                                                          () -> new RuntimeException("User non trouvé"));
                              return user;
               }

               public User createUser(User user) {
                              User newUser = userRepository.save(user);
                              return newUser;
               }

               public User updateUser(Long id, User user) {
                              User userToUpdate = userRepository
                                                            .findById(id)
                                                            .orElseThrow(
                                                                                          () -> new RuntimeException("User avec l'id"
                                                                                                                        + id
                                                                                                                        + "non trouvé"));

                              userToUpdate.setUsername(user.getUsername());
                              userToUpdate.setEmail(user.getEmail());
                              userToUpdate.setPassword(user.getPassword());
                              return userToUpdate;
               }

               public void deleteUser(Long id) {
                              userRepository.deleteById(id);
               }

}
