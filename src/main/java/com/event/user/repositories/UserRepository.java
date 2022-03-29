
package com.event.user.repositories;

import com.event.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserIDAndPassword(String userId, String password);
}
