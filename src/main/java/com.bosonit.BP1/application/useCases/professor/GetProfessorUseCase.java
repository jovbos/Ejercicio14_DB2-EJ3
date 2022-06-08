package com.bosonit.BP1.application.useCases.professor;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.professor.GetProfessorPort;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.repositories.ProfessorRepository;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorFullOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetProfessorUseCase implements GetProfessorPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProfessorRepository professorRepository;

    public ResponseEntity<ProfessorOutputDTO> getProfessorId(String id, String outputType) throws Exception {

        ProfessorOutputDTO professorOutputDTO;
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new CustomErrorRequest404("PROFESSOR NOT REGISTERED"));
        if (outputType.equals("full")){
            ProfessorFullOutputDTO professorFullOutputDTO = modelMapper.map(professor, ProfessorFullOutputDTO.class);
            professorFullOutputDTO.setId_person(professor.getPerson().getId());
            professorFullOutputDTO.setPersonOutputDTO(modelMapper.map(professor.getPerson(), PersonOutputDTO.class));


            return ResponseEntity.ok().body(professorFullOutputDTO);

        } else {
            professorOutputDTO = modelMapper.map(professor, ProfessorOutputDTO.class);

            return ResponseEntity.ok().body(professorOutputDTO);
        }
    }

    public List<ProfessorOutputDTO> getProfessorAll() {

        List<ProfessorOutputDTO> listDTO = new ArrayList<>();
        List<Professor> ProfessorList = professorRepository.findAll();
        ProfessorList.forEach(p -> {
            ProfessorOutputDTO ProfessorOutputDTO = modelMapper.map(p, ProfessorOutputDTO.class);
            listDTO.add(ProfessorOutputDTO);
        });

        return listDTO;
    }


}
