package com.shim.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shim.todolist.model.Task;
import com.shim.todolist.service.TaskService;

@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/add")
	public String add(@RequestBody Task task) {
		taskService.saveTask(task);
		return "New task is added";
	}
	
	@GetMapping("/getAll")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	@GetMapping("/get/{id}")
	public Task getTaskById(@PathVariable int id) {
		return taskService.getTaskById(id);
	}

	@PutMapping("/update/{id}")
	public String updateTask(@PathVariable int id, @RequestBody Task task) {
		Task existingTask = taskService.getTaskById(id);
		if (existingTask != null) {
			existingTask.setTitle(task.getTitle());
			existingTask.setUrl(task.getUrl());
			taskService.saveTask(existingTask);
			return "Task updated successfully";
		} else {
			return "Task not found";
		}
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTask(@PathVariable int id) {
		Task task = taskService.getTaskById(id);
		if (task != null) {
			taskService.deleteTask(id);
			return "Task deleted successfully";
		} else {
			return "Task not found";
		}
	}
}
