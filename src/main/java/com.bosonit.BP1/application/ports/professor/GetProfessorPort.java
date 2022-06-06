package com.bosonit.BP1.application.ports.professor;

import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetProfessorPort {

    public ResponseEntity<ProfessorOutputDTO> getProfessorId(String id) throws Exception;

//    public List<ProfessorOutputDTO> getProfessorName(String name);

    public List<ProfessorOutputDTO> getProfessorAll();
}
