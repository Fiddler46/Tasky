package com.fiddler46.tasky.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.fiddler46.tasky.model.Task;

public interface TaskRepository extends MongoRepository<Task, String>{

}
