package com.shaon.NHSystem.service;


import com.shaon.NHSystem.model.Task;
import com.shaon.NHSystem.model.User;
import com.shaon.NHSystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserByTask(User user){
        return taskRepository.findByUser(user);
    }
}
