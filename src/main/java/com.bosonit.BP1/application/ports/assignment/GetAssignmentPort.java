package com.bosonit.BP1.application.ports.assignment;

import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface GetAssignmentPort {

    public ResponseEntity<AssignmentOutputDTO> getAssignmentId(Integer id) throws Exception;

    public List<AssignmentOutputDTO> getAssignmentName(String name);

    public List<AssignmentOutputDTO> getAssignmentAll();
}
