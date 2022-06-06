package com.bosonit.BP1.infracstructure.controllers.assignment;

import com.bosonit.BP1.application.ports.assignment.GetAssignmentPort;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAssignmentController {

    @Autowired
    GetAssignmentPort getPort;

    @GetMapping("/assignment/{id}")
    public ResponseEntity<AssignmentOutputDTO> getAssignmentId(@PathVariable("id") Integer id) throws Exception {

        return getPort.getAssignmentId(id);
    }

    @GetMapping("/assignment/name/{name}")
    public List<AssignmentOutputDTO> getAssignmentName(@PathVariable("name") String name) {

        return getPort.getAssignmentName(name);
    }

    @GetMapping("/assignment")
    public List<AssignmentOutputDTO> getAssignmentAll() {

        return getPort.getAssignmentAll();
    }
}
