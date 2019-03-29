package com.shaon.NHSystem.repository;

import com.shaon.NHSystem.model.Role;
import com.shaon.NHSystem.model.Task;
import com.shaon.NHSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
