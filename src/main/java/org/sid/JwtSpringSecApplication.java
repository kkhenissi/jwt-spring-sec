package org.sid;

import java.util.stream.Stream;


import org.sid.dao.TaskRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.entities.Task;
import org.sid.servive.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JwtSpringSecApplication implements  CommandLineRunner{
    @Autowired
	TaskRepository taskRepository;
    @Autowired
    private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... arg0) throws Exception {
	accountService.saveUser(new AppUser(null, "admin", "1234", null));
	accountService.saveUser(new AppUser(null, "user", "1234", null));
	accountService.saveRole(new AppRole(null, "ADMIN"));
	accountService.saveRole(new AppRole(null, "USER"));
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
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
