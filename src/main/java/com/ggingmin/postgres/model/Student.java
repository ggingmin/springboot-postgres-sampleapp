package com.ggingmin.postgres.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id")
    private Long id;


    @Column(name = "stud_name", nullable = false)
    private String name;

    @Column(name = "stud_email", nullable = false, unique = true)
    private String email;

    @Column(name = "stud_num", nullable = false, unique = true)
    private Long studentNumber;

    @Column(name = "stud_type", nullable = false)
    private StudentType type;

}