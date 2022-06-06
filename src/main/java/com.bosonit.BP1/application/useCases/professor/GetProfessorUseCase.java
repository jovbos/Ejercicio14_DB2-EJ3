package com.bosonit.BP1.application.useCases.professor;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.professor.GetProfessorPort;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.repositories.ProfessorRepository;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetProfessorUseCase implements GetProfessorPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProfessorRepository repository;

    public ResponseEntity<ProfessorOutputDTO> getProfessorId(String id) throws Exception {

        if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
        else {
            Professor professor = repository.findById(id).orElseThrow(() -> new Exception("Professor not registered."));
            ProfessorOutputDTO professorOut = modelMapper.map(professor, ProfessorOutputDTO.class);

            return ResponseEntity.ok().body(professorOut);
        }
    }

//    public List<ProfessorOutputDTO> getProfessorName(String name) {
//
//        List<ProfessorOutputDTO> listDTO = new ArrayList<>();
//        List<Professor> ProfessorList = repository.findByName(name);
//        ProfessorList.forEach(p -> {
//            ProfessorOutputDTO ProfessorOutputDTO = modelMapper.map(p, ProfessorOutputDTO.class);
//            listDTO.add(ProfessorOutputDTO);
//        });
//
//        return listDTO;
//    }
    public List<ProfessorOutputDTO> getProfessorAll() {

        List<ProfessorOutputDTO> listDTO = new ArrayList<>();
        List<Professor> ProfessorList = repository.findAll();
        ProfessorList.forEach(p -> {
            ProfessorOutputDTO ProfessorOutputDTO = modelMapper.map(p, ProfessorOutputDTO.class);
            listDTO.add(ProfessorOutputDTO);
        });

        return listDTO;
    }


}
