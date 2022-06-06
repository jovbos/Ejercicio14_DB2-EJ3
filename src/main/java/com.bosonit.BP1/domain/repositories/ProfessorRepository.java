package com.bosonit.BP1.domain.repositories;

import com.bosonit.BP1.domain.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
}
