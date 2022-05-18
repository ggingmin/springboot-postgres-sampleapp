package com.ggingmin.postgres.service;

import com.ggingmin.postgres.model.Student;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StudentService {

    public Student saveStudent(Student student);
    public Page<Student> getAllStudent(Integer page, Integer size, Boolean enablePagination);
    public Optional<Student> findById(Long id);
    public Student editStudent(Student student);
    public void deleteStudent(Long id);
    public boolean existsById(Long id);
}
