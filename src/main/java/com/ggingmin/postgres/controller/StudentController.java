package com.ggingmin.postgres.controller;

import com.ggingmin.postgres.model.Student;
import com.ggingmin.postgres.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping(value = "/student")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/student")
    public ResponseEntity<Page<Student>> getAllStudent(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination
    ) {
        try {
            return ResponseEntity.ok(studentService.getAllStudent(page, size, enablePagination));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/student/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(studentService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @DeleteMapping(value = "/student/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        try {
            studentService.deleteStudent(id);
            ResponseEntity.ok(!studentService.existsById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(value = "/student")
    public ResponseEntity<Student> editStudent(@Valid @RequestBody Student student) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.editStudent(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
