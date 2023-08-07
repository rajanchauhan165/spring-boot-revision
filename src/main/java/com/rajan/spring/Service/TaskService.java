package com.rajan.spring.Service;

import com.rajan.spring.Entities.Tasks;

public interface TaskService {
	public Tasks addTask(Integer userId, Tasks tasks);
	public Tasks deleTasks(Integer taskId);
	public Tasks modifyTasks(Integer taskId, Tasks tasks);
}
