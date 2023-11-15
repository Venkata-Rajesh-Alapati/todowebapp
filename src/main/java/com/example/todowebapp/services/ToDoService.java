package com.example.todowebapp.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.example.todowebapp.beans.ToDo;

@Component
public class ToDoService {

	private static List<ToDo> TODOS = new ArrayList<>();

	private static int todoId = 0;

	static {
		TODOS.add(new ToDo(++todoId, "Venkata", "Learn Java", LocalDate.now().minusDays(10), true));
		TODOS.add(new ToDo(++todoId, "Venkata", "Learn Spring", LocalDate.now().plusMonths(5), false));
		TODOS.add(new ToDo(++todoId, "Venkata", "Learn AWS", LocalDate.now().plusYears(1), false));
		TODOS.add(new ToDo(++todoId, "Rajesh", "Learn GCP", LocalDate.now().plusYears(1), false));
	}

	public List<ToDo> getToDos(String username) {
		Predicate<? super ToDo> pred = (todo -> todo.getUsername().equals(username));
		return TODOS.stream().filter(pred).toList();
	}

	public void addToDo(String username, String description, LocalDate date, boolean done) {
		TODOS.add(new ToDo(++todoId, username, description, date, done));
	}
	
	public void deleteToDo(int id) {
		Predicate<? super ToDo> pred = (todo -> todo.getId() == id);
		TODOS.removeIf(pred);
	}
	
	public ToDo getToDo(int id) {
		Predicate<? super ToDo> pred = (todo -> todo.getId() == id);
		return TODOS.stream().filter(pred).findFirst().get();
	}
	
	public void update(ToDo todo) {
		deleteToDo(todo.getId());
		TODOS.add(todo);
	}
	
	
}
