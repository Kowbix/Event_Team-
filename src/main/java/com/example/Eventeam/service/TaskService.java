package com.example.Eventeam.service;

import com.example.Eventeam.entity.Task;
import com.example.Eventeam.exception.TaskNotFoundException;
import com.example.Eventeam.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksWithoutMatch(List<Task> tasksAssignedToMatch) {

        List<Task> tasks = taskRepository.findAll();
        tasks.removeAll(tasksAssignedToMatch);

        return tasks;
    }

    public Task updateTask (Task task) {
        return taskRepository.save(task);
    }

    public Task findTaskById(Long id) {
        return taskRepository.findTaskById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task by id " + id + "was not found"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
