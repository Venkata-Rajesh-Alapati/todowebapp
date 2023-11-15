package com.example.todowebapp.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todowebapp.beans.ToDo;

public interface ToDoDataJpa extends JpaRepository<ToDo, Integer>{
	List<ToDo> findByUsername(String username);
}
