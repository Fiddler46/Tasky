package com.fiddler46.tasky.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fiddler46.tasky.model.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{

}
