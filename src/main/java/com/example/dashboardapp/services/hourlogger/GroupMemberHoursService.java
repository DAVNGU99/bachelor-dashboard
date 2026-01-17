package com.example.dashboardapp.services.hourlogger;

import com.example.dashboardapp.domain.entities.hourlogger.GroupMemberHours;
import com.example.dashboardapp.repositories.hourlogger.GroupMemberHoursRepository;
import com.example.dashboardapp.repositories.hourlogger.GroupMemberRepository;
import com.example.dashboardapp.repositories.hourlogger.WeekRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GroupMemberHoursService {

    private final GroupMemberHoursRepository groupMemberHoursRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final WeekRepository weekRepository;


    public GroupMemberHoursService(GroupMemberHoursRepository groupMemberHoursRepository, GroupMemberRepository groupMemberRepository, WeekRepository weekRepository) {
        this.groupMemberHoursRepository = groupMemberHoursRepository;
        this.groupMemberRepository = groupMemberRepository;
        this.weekRepository = weekRepository;
    }

   

}
