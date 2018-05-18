package com.eventgate.backend.service.repository;

import com.eventgate.backend.service.model.EventRegistryQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRegistryQuestionRepository extends JpaRepository<EventRegistryQuestion, Integer> {
}
