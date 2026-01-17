package com.example.dashboardapp.repositories.hourlogger;

import com.example.dashboardapp.domain.entities.hourlogger.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Integer> {
}
