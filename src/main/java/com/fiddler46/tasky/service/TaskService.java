package com.fiddler46.tasky.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.fiddler46.tasky.model.Task;
import com.fiddler46.tasky.repositories.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(String id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public ResponseEntity<Task> updateTask(String taskId, Task updatedTask) {
        return taskRepository.findById(taskId)
            .map(task -> {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setStatus(updatedTask.isStatus());
                task.setDueDate(updatedTask.getDueDate());
                Task updatedTaskEntity = taskRepository.save(task);
                return ResponseEntity.ok(updatedTaskEntity);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}