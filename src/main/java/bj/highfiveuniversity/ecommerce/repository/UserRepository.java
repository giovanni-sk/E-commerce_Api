package bj.highfiveuniversity.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.ecommerce.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
               
}
