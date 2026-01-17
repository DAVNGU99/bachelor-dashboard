package com.example.dashboardapp.services.hourlogger;

import com.example.dashboardapp.domain.entities.hourlogger.GroupMember;
import com.example.dashboardapp.domain.entities.hourlogger.GroupMemberHours;
import com.example.dashboardapp.domain.entities.hourlogger.MemberWeekHoursId;
import com.example.dashboardapp.domain.entities.hourlogger.Week;
import com.example.dashboardapp.repositories.hourlogger.GroupMemberHoursRepository;
import com.example.dashboardapp.repositories.hourlogger.GroupMemberRepository;
import com.example.dashboardapp.repositories.hourlogger.WeekRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    public List<GroupMemberHours> getGroupMemberHours() {
        return groupMemberHoursRepository.findAll();
    }


    public Page<GroupMemberHours> getHoursForAGivenWeek(Integer weekNumber, Pageable pageable) {
        return groupMemberHoursRepository.findByWeek_WeekNumber(weekNumber, pageable);
    }

    @Transactional
    public GroupMemberHours incrementHour(Integer memberId, Integer weekId) {

        GroupMember member = groupMemberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Kan ikke finne gruppemedlem med denne id"));

        Week week = weekRepository.findById(weekId).orElseThrow(() -> new IllegalArgumentException("Kan ikke finne ukenummer"));


        MemberWeekHoursId id = new MemberWeekHoursId(memberId, weekId);

        GroupMemberHours groupMemberHours = groupMemberHoursRepository.findById(id)
                .orElseGet(() -> new GroupMemberHours(member, week));


        groupMemberHours.increment();

        return groupMemberHoursRepository.save(groupMemberHours);


    }

    @Transactional
    public GroupMemberHours decrementHour(Integer memberId, Integer weekId) {

        GroupMember member = groupMemberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Kunne ikke finne medlem med denne id"));

        Week week = weekRepository.findById(weekId)
                .orElseThrow(() -> new IllegalArgumentException("Kan ikke finne ukernummer"));

        MemberWeekHoursId id = new MemberWeekHoursId(memberId, weekId);

        GroupMemberHours groupMemberHours = groupMemberHoursRepository.findById(id)
                .orElseGet(() -> new GroupMemberHours(member, week));

        groupMemberHours.decrement();

        return groupMemberHoursRepository.save(groupMemberHours);

    }

}
