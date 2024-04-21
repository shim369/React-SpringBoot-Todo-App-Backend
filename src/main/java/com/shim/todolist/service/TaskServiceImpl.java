package com.shim.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shim.todolist.model.Task;
import com.shim.todolist.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
}