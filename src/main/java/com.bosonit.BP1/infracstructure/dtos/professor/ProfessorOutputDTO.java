package com.bosonit.BP1.infracstructure.dtos.professor;

import com.bosonit.BP1.domain.entities.Assignment;
import lombok.Data;

@Data
public class ProfessorOutputDTO {

    private String id_professor;

    private Assignment assignment;

    private String branch;

    private String comments;
}
