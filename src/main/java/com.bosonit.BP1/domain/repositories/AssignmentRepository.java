package com.bosonit.BP1.domain.repositories;

import com.bosonit.BP1.domain.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    List<Assignment> findByName(String name);
}
