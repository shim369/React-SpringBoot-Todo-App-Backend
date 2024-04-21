package com.shim.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shim.todolist.model.Task;
import com.shim.todolist.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/add")
	public String add(@RequestBody Task task) {
		taskService.saveTask(task);
		return "New task is added";
	}

}
