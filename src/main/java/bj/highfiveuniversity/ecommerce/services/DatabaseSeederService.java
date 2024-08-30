package bj.highfiveuniversity.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import bj.highfiveuniversity.ecommerce.models.User;
import bj.highfiveuniversity.ecommerce.repository.UserRepository;

@Service
public class DatabaseSeederService {
               @Autowired
               UserRepository userRepository;
               private final Faker faker = new Faker();

               public void seedDataBase() {
                              for (int i = 0; i < 10; i++) {
                                             String username = faker.name().username();
                                             String email = username + "@example.com";
                                             String password = faker.internet().password();
                                             User user = User.builder()
                                                                           .email(email)
                                                                           .username(username)
                                                                           .password(password).build();

                                             userRepository.save(user);
                              }
               }
}
