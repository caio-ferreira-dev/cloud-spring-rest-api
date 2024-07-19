package dev.caioferreira.cloud_api.domain.repository;

import dev.caioferreira.cloud_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface UserRepository extends JpaRepository<User, Long>{
}
