package com.bosonit.BP1.application.ports.assignment;

import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;
import org.springframework.http.ResponseEntity;

public interface UpdateAssignmentPort {

    public ResponseEntity<AssignmentOutputDTO> updateAssignment (Integer id, AssignmentInputDTO assignmentDTO);
}
