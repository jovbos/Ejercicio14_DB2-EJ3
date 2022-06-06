package com.bosonit.BP1.infracstructure.controllers.assignment;

import com.bosonit.BP1.application.ports.assignment.CreateAssignmentPort;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateAssignmentController {

    @Autowired
    CreateAssignmentPort createPort;

    @PostMapping("/assignment")
    public AssignmentOutputDTO createAssigment(@RequestBody AssignmentInputDTO assignmentDTO) throws Exception {

        return createPort.addAssignment(assignmentDTO);

    }

}
