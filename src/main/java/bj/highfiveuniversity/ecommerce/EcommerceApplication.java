package bj.highfiveuniversity.ecommerce;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bj.highfiveuniversity.ecommerce.models.User;
import bj.highfiveuniversity.ecommerce.repository.UserRepository;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			/* Sauvegarder John doe dans la base de donnée */
			User john = User.builder()
					.email("example@example.com")
					.username("John doe")
					.password("123")
					.createdAt(null)
					.updatedAt(null)
					.build();

			User jane = new User(
					2L,
					"Jane Doe",
					"jane@example.com",
					"123456",
					null,
					null,
					new ArrayList<>());

			User bobe = new User(
					3L,
					"bob Bone",
					"jane@example.com",
					"123456",
					null,
					null,
					new ArrayList<>());

			userRepository.save(jane);
			userRepository.save(john);
			userRepository.save(bobe);
		};
	}
}
