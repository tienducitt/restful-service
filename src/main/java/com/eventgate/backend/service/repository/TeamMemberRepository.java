package com.eventgate.backend.service.repository;

import com.eventgate.backend.service.model.TeamMember;
import com.eventgate.backend.service.model.TeamMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, TeamMemberId> {
}
