package com.eventgate.backend.service.repository;

import com.eventgate.backend.service.model.EventRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRegistryRepository extends JpaRepository<EventRegistry, Integer> {
}
