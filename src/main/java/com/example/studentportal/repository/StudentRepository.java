package com.example.studentportal.repository;

import com.example.studentportal.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    Student findByUsernameAndPassword(String username, String password);
}