package com.example.studentportal.service;

import com.example.studentportal.model.Student;
import com.example.studentportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student registerStudent(Student student) {
        if (studentRepository.existsById(student.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return studentRepository.save(student);
    }

    public Student loginStudent(String username, String password) {
        Student student = studentRepository.findByUsernameAndPassword(username, password);
        if (student == null) {
            throw new RuntimeException("Invalid credentials");
        }
        return student;
    }
}