package bj.highfiveuniversity.ecommerce;

import java.time.LocalDateTime;

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
			/* Sauvegarder John doe dans la base de donnée*/
			User john = User.builder()
					.email("example@example.com")
					.username("John doe")
					.password("123")
					.createdAt(LocalDateTime.now())
					.updatedAt(LocalDateTime.now())
					.build();
					userRepository.save(john);
			User jane = new User(null, "Jane Doe", "jane@example.com", "123456",
					LocalDateTime.now(), LocalDateTime.now());
			userRepository.save(jane);
		};
	}
}

