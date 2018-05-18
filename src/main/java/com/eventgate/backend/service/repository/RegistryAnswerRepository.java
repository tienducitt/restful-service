package com.eventgate.backend.service.repository;

import com.eventgate.backend.service.model.RegistryAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryAnswerRepository extends JpaRepository<RegistryAnswer, Integer> {
}
