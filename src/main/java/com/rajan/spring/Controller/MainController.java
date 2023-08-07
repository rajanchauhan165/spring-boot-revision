package com.rajan.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajan.spring.Entities.Tasks;
import com.rajan.spring.Entities.User;
import com.rajan.spring.Service.TaskService;
import com.rajan.spring.Service.UserService;

@RestController
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
	}
	
	@PutMapping("/user/{userid}")
	public ResponseEntity<User> editUser(@PathVariable("userid") Integer userId, @RequestBody User user){
		return new ResponseEntity<User>(userService.editUserDetails(userId, user),HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userid}")
	public ResponseEntity<User> deleteUser(@PathVariable("userid")Integer userid){
		return new ResponseEntity<>(userService.deletUser(userid),HttpStatus.OK);
	}
	
	@PostMapping("/task/{userid}")
	public ResponseEntity<Tasks> addTask(@PathVariable("userid") Integer userid,@RequestBody Tasks tasks){
		return new ResponseEntity<Tasks>(taskService.addTask(userid,tasks),HttpStatus.OK);
	}
	
	@PutMapping("/task/{taskid}")
	public ResponseEntity<Tasks> editTask(@PathVariable("taskid")Integer taskid,@RequestBody Tasks tasks){
		return new ResponseEntity<Tasks>(taskService.modifyTasks(taskid, tasks),HttpStatus.OK);
	}
	
	@DeleteMapping("task/{taskid}")
	public ResponseEntity<Tasks> deleteTask(@PathVariable("taskid")Integer taskid){
		return new ResponseEntity<Tasks>(taskService.deleTasks(taskid), HttpStatus.OK);
	}
}
