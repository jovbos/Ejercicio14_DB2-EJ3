package com.bosonit.BP1.infracstructure.dtos.subject;

import com.bosonit.BP1.domain.entities.Student;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class SubjectInputDTO {

    private String id_subject;

    private Student student;

    private String name;

    private String comments;

    private Date initial_date;

    private Date finish_date;

}
