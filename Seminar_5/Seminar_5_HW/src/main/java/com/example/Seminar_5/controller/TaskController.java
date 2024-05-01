package com.example.Seminar_5.controller;

import com.example.Seminar_5.model.Task;
import com.example.Seminar_5.model.TaskStatus;
import com.example.Seminar_5.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/task-add")
    public Task addTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.getTaskByStatus(status);
    }

    @PutMapping("/{id}/{status}")
    public Task updateTaskStatus(@PathVariable Long id, @PathVariable TaskStatus status){
        return taskService.updateTask(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
