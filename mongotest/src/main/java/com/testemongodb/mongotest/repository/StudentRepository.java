package com.testemongodb.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testemongodb.mongotest.model.Student;

public interface StudentRepository extends MongoRepository<Student, Long>{
    
}
