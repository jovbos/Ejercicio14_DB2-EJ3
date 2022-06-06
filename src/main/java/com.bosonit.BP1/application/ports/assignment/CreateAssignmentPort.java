package com.bosonit.BP1.application.ports.assignment;

import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;

public interface CreateAssignmentPort {
    public AssignmentOutputDTO addAssignment(AssignmentInputDTO assignmentDTO) throws Exception ;
}
