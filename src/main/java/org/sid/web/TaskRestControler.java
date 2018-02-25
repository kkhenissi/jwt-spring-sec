package org.sid.web;

import java.util.List;

import org.sid.dao.TaskRepository;
import org.sid.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class TaskRestControler {
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/tasks")
    public List<Task> taskList(){
    	
    	
		return taskRepository.findAll();
    	
    }
	
	// methode pour ajouter une tahe
	@PostMapping("/saveTask")
	public Task addTask(@RequestBody Task t) {
		
		return taskRepository.save(t);
		
		
	}
}
