package com.example.ToDoList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoList.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
