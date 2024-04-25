package com.shim.todolist.service;

import java.util.List;

import com.shim.todolist.model.Task;

public interface TaskService {
	public Task saveTask(Task task);
	public List<Task> getAllTasks();
	public Task getTaskById(int id);
	public void deleteTask(int id);
}
