package com.tuana9a.learnjavaspringweb.repository;

import com.tuana9a.learnjavaspringweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo3 extends JpaRepository<User, Integer> {
    boolean existsByUsernameAndDeletedFalse(String username);

    boolean existsByUsernameAndPasswordAndDeletedFalse(String username, String password);

    User findByUsernameAndDeletedFalse(String username);
}
