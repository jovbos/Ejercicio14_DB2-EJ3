package com.bosonit.BP1.application.useCases.subject;

import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.subject.CreateSubjectPort;
import com.bosonit.BP1.domain.entities.Subject;
import com.bosonit.BP1.domain.repositories.SubjectRepository;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateSubjectUseCase implements CreateSubjectPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SubjectRepository repository;

    public SubjectOutputDTO addSubject(SubjectInputDTO subjectDTO){

        Subject subject = modelMapper.map(subjectDTO, Subject.class);

        if (subject.getInitial_date() == null)
        throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
        repository.save(subject);

        return modelMapper.map(subject, SubjectOutputDTO.class);
    }
}
