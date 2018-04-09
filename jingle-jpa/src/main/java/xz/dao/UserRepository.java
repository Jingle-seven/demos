package xz.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import xz.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    @Transactional(timeout = 10)
    @Query("select u from User u where u.id > ?1 and authority = ?2")
    List<User> findByIdAndAuth(Long id,Integer auth);
}