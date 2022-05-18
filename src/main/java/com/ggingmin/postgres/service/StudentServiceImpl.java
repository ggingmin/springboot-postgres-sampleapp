package com.ggingmin.postgres.service;

import com.ggingmin.postgres.model.Student;
import com.ggingmin.postgres.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student saveStudent(Student student) {
        try {
            if (student.getId() != null) {
                return studentDao.save(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Student> getAllStudent(Integer page, Integer size, Boolean enablePagination) {
        try {
            return studentDao.findAll(enablePagination ? PageRequest.of(page, size) : Pageable.unpaged());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Student> findById(Long id) {
        try {
            return studentDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student editStudent(Student student) {
        try {
            if (student.getId() != null && studentDao.existsById(student.getId())) {
                return studentDao.save(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        try {
            studentDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existsById(Long id) {
        try {
            return studentDao.existsById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
