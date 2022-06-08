package com.bosonit.BP1.infracstructure.dtos.person;

import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import lombok.Data;

import java.util.Date;

@Data
public class PersonStuDTO extends PersonOutputDTO {
    
    private StudentOutputDTO student;

}
