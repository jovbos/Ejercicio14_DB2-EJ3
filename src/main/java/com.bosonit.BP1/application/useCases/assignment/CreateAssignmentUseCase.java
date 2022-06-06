package com.bosonit.BP1.application.useCases.assignment;

import com.bosonit.BP1.application.ports.assignment.CreateAssignmentPort;
import com.bosonit.BP1.domain.entities.Assignment;
import com.bosonit.BP1.domain.repositories.AssignmentRepository;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateAssignmentUseCase implements CreateAssignmentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AssignmentRepository repository;

    public AssignmentOutputDTO addAssignment(AssignmentInputDTO assignmentDTO){

        Assignment assignment = modelMapper.map(assignmentDTO, Assignment.class);

        if (assignment.getUsuario() == null || assignment.getPassword() == null || assignment.getName() == null || assignment.getCompany_email() == null
        || assignment.getPersonal_email() == null || assignment.getCity() == null || assignment.getActive() == null || assignment.getCreated_date() == null
        || assignment.getUsuario().length() > 10) throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
        repository.save(assignment);

        return modelMapper.map(assignment, AssignmentOutputDTO.class);
    }
}
