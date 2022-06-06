package com.bosonit.BP1.application.useCases.professor;

import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.professor.CreateProfessorPort;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.repositories.ProfessorRepository;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorInputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateProfessorUseCase implements CreateProfessorPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProfessorRepository repository;

    public ProfessorOutputDTO addProfessor(ProfessorInputDTO professorDTO){

        Professor professor = modelMapper.map(professorDTO, Professor.class);

        if (professor.getBranch() == null)
        throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
        repository.save(professor);

        return modelMapper.map(professor, ProfessorOutputDTO.class);
    }
}
