package com.kfss.TaskManagementSystem.Task;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kfss.TaskManagementSystem.util.ResourceNotFoundException;

public class TaskService {
	
	
	@Autowired
	private TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task createTask(Task task) {
		task.setCreatedAt(LocalDate.now());
		return taskRepository.save(task);
	}

	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}

	public Task getTaskById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrado"));
	}

	public Task updateTask(Long id, Task taskDetails) {
		Task task = getTaskById(id);
		task.setTitle(taskDetails.getTitle());
		task.setDescription(taskDetails.getDescription());
		task.setStatus(taskDetails.getStatus());
		task.setDueDate(taskDetails.getDueDate());
		return taskRepository.save(task);
	}
	
	public void deleteTask(Long id) {
		Task task = getTaskById(id);
	    taskRepository.delete(task);
		
	}

}
