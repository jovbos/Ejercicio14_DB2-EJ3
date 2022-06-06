package com.bosonit.BP1.application.useCases.assignment;

import com.bosonit.BP1.application.ports.assignment.DeleteAssignmentPort;
import com.bosonit.BP1.domain.entities.Assignment;
import com.bosonit.BP1.domain.repositories.AssignmentRepository;
import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteAssignmentUseCase  implements DeleteAssignmentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AssignmentRepository repository;

    public ResponseEntity<AssignmentOutputDTO> deleteAssignment(Integer id)  throws Exception {
    if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
    else {
          Assignment assignment = repository.findById(id).orElseThrow(() -> new Exception("Assignment not registered."));
          repository.delete(assignment);

          return ResponseEntity.ok().build();
        }
    }
}
