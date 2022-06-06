package com.bosonit.BP1.infracstructure.dtos.student;

import com.bosonit.BP1.domain.entities.Assignment;
import com.bosonit.BP1.domain.entities.Professor;
import lombok.Data;

import java.util.Date;

@Data
public class StudentFullOutputDTO{

    private String id_student;

    private Assignment assignment;

    private Integer hours_per_week;

    private String comments;

    private Professor professor;

    private String branch;

//    private List<Subject> subjects;

}
