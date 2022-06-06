package com.bosonit.BP1.application.useCases.subject;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.subject.UpdateSubjectPort;
import com.bosonit.BP1.domain.entities.Subject;
import com.bosonit.BP1.domain.repositories.SubjectRepository;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateSubjectUseCase implements UpdateSubjectPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SubjectRepository repository;

    public ResponseEntity<SubjectOutputDTO> updateSubject (String id, SubjectInputDTO subjectDTO) {

        if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
            else{
                Subject subject = modelMapper.map(subjectDTO, Subject.class);
                subject.setId_subject(id);

                if (subject.getInitial_date() == null)
                throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
                repository.save(subject);

                SubjectOutputDTO subjectOut = modelMapper.map(subject, SubjectOutputDTO.class);

            return ResponseEntity.ok().body(subjectOut);
         }
    }
}
