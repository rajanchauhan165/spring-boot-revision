package com.rajan.spring.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rajan.spring.Entities.Tasks;
import com.rajan.spring.Entities.User;
import com.rajan.spring.Repositories.TaskRepo;
import com.rajan.spring.Repositories.UserRepo;
@Service
public class UserTaskImpl implements TaskService,UserService{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TaskRepo taskRepo;

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User deletUser(Integer userId) {
		Optional<User> user = userRepo.findById(userId);
		userRepo.delete(user.get());
		return user.get();
		
	}

	@Override
	public User editUserDetails(Integer userId, User user) {
		Optional<User> optional = userRepo.findById(userId);
		User extUser = optional.get();
		extUser.setName(user.getName());
		extUser.setPassword(user.getPassword());
		userRepo.save(extUser);
		return extUser;
	}

	@Override
	public Tasks addTask(Integer userId, Tasks tasks) {
		return taskRepo.save(tasks);
		
	}

	@Override
	public Tasks deleTasks(Integer taskId) {
		Optional<Tasks> optional = taskRepo.findById(taskId);
		Tasks tasks = optional.get();
		taskRepo.delete(tasks);
		return tasks;
	}

	@Override
	public Tasks modifyTasks(Integer taskId, Tasks tasks) {
		Optional<Tasks> optional = taskRepo.findById(taskId);
		Tasks task = optional.get();
		task.setTitle(tasks.getTitle());
		task.setDescription(tasks.getDescription());
		taskRepo.save(task);
		return task;
	}

}
