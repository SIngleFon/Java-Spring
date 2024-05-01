package com.example.Seminar_5.service;

import com.example.Seminar_5.model.Task;
import com.example.Seminar_5.model.TaskStatus;
import com.example.Seminar_5.repisitory.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTaskByStatus(TaskStatus taskStatus) {
        return taskRepository.findAllByStatus(taskStatus);
    }

    public void updateTaskStatus(Task task) {
        taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskStatus status) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(status);
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}


