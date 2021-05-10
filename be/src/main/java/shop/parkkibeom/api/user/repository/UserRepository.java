package shop.parkkibeom.api.user.repository;

import shop.parkkibeom.api.user.domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserVo, Long> {
    boolean existsByUsername(String username);
    UserVo findByUsername(String username);

    @Query (value = "SELECT * FROM users WHERE username = :username AND password = :password", nativeQuery = true)
    UserVo signin(@Param("username") String username, @Param("password") String password);
}
