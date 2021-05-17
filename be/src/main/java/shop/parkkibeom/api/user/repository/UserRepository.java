package shop.parkkibeom.api.user.repository;

import shop.parkkibeom.api.user.domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserVo, Long> {
    boolean existsByUsername(String username);
    Optional<UserVo> findByUsername(String username); // 테이블 목록이 보이는 상태에서 눌러서 가져오는 것은 get, 없을 수도 있는 모르는 상태에서 가져오는 것은 find

    @Query (value = "SELECT * FROM users WHERE username = :username AND password = :password", nativeQuery = true)
    UserVo signin(@Param("username") String username, @Param("password") String password);
}
