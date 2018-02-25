package org.sid;

import java.util.stream.Stream;

import org.sid.dao.TaskRepository;
import org.sid.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtSpringSecApplication implements  CommandLineRunner{
    @Autowired
	TaskRepository taskRepository;
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
	
		
		Stream.of("t1","t2","t3").forEach(t->{
			Task tache = new Task();
			tache.setTaskName(t);
			taskRepository.save(tache);
			taskRepository.findAll().forEach(tsk->{
				System.out.println(tsk.getTaskName());
				
			});
			
		});
		
		
		
	}
}
