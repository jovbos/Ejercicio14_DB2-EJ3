package com.bosonit.BP1.domain.repositories;

import com.bosonit.BP1.domain.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
