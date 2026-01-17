package com.example.dashboardapp.repositories.hourlogger;

import com.example.dashboardapp.domain.entities.hourlogger.GroupMemberHours;
import com.example.dashboardapp.domain.entities.hourlogger.MemberWeekHoursId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberHoursRepository extends JpaRepository<GroupMemberHours, MemberWeekHoursId> {
}
