package com.bosonit.BP1.application.ports.assignment;

import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;
import org.springframework.http.ResponseEntity;

public interface DeleteAssignmentPort {

    public ResponseEntity<AssignmentOutputDTO> deleteAssignment(Integer id) throws Exception;
}
