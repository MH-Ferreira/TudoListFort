package com.example.ToDoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoList.Repository.TaskRepository;
import com.example.ToDoList.entity.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	 @Autowired
	    private TaskRepository taskRepository;

	    // Listar todas as tarefas
	    @GetMapping
	    public List<Task> getAllTasks() {
	        return taskRepository.findAll();
	    }

	    // Criar nova tarefa
	    @PostMapping
	    public Task createTask(@RequestBody Task task) {
	        return taskRepository.save(task);
	    }

	    // Atualizar tarefa
	    @PutMapping("/{id}")
	    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
	        Task existingTask = taskRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
	        
	        existingTask.setTitle(task.getTitle());
	        existingTask.setCompleted(task.isCompleted());
	        
	        return taskRepository.save(existingTask);
	    }

	    // Deletar tarefa
	    @DeleteMapping("/{id}")
	    public void deleteTask(@PathVariable Long id) {
	        taskRepository.deleteById(id);
	    }
}
