package com.bosonit.BP1.infracstructure.dtos.professor;

import com.bosonit.BP1.domain.entities.Assignment;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ProfessorOutputDTO {

    private String id_professor;

    private Assignment assignment;

    private String branch;

    private String comments;

}
