package com.bosonit.BP1.domain.repositories;

import com.bosonit.BP1.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
