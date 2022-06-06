package com.bosonit.BP1.application.useCases.assignment;

import com.bosonit.BP1.application.ports.assignment.GetAssignmentPort;
import com.bosonit.BP1.domain.entities.Assignment;
import com.bosonit.BP1.domain.repositories.AssignmentRepository;
import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.infracstructure.dtos.assignment.AssignmentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAssignmentUseCase implements GetAssignmentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AssignmentRepository repository;

    public ResponseEntity<AssignmentOutputDTO> getAssignmentId(Integer id) throws Exception {

        if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
        else {
            Assignment assignment = repository.findById(id).orElseThrow(() -> new Exception("Assignment not registered."));
            AssignmentOutputDTO assignmentOut = modelMapper.map(assignment, AssignmentOutputDTO.class);

            return ResponseEntity.ok().body(assignmentOut);
        }
    }

    public List<AssignmentOutputDTO> getAssignmentName(String name) {

        List<AssignmentOutputDTO> listDTO = new ArrayList<>();
        List<Assignment> assignmentList = repository.findByName(name);
        assignmentList.forEach(p -> {
            AssignmentOutputDTO assignmentOutputDTO = modelMapper.map(p, AssignmentOutputDTO.class);
            listDTO.add(assignmentOutputDTO);
        });

        return listDTO;
    }
    public List<AssignmentOutputDTO> getAssignmentAll() {

        List<AssignmentOutputDTO> listDTO = new ArrayList<>();
        List<Assignment> assignmentList = repository.findAll();
        assignmentList.forEach(p -> {
            AssignmentOutputDTO assignmentOutputDTO = modelMapper.map(p, AssignmentOutputDTO.class);
            listDTO.add(assignmentOutputDTO);
        });

        return listDTO;
    }


}
