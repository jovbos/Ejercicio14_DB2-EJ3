package com.bosonit.BP1.infracstructure.controllers.assignment;

import com.bosonit.BP1.application.ports.assignment.UpdateAssignmentPort;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UptdateAssignmentController {

    @Autowired
    UpdateAssignmentPort updatePort;

    @PutMapping("/assignment/{id}")
    public ResponseEntity<AssignmentOutputDTO> updateAssignment(@PathVariable("id") Integer id, @RequestBody AssignmentInputDTO assignmentDTO) {

        return updatePort.updateAssignment(id, assignmentDTO);
    }

}
