package com.shaon.NHSystem.repository;

import com.shaon.NHSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findOneByEmail(String email);

    List<User> findByNameLike(String name);
}
