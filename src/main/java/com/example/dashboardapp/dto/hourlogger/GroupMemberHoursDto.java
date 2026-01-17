package com.example.dashboardapp.dto.hourlogger;

import com.example.dashboardapp.domain.entities.hourlogger.GroupMemberHours;


public record GroupMemberHoursDto(
        Integer memberId,
        String memberName,
        Integer weekId,
        Integer weekNumber,
        int hours
) {

    public static GroupMemberHoursDto from (GroupMemberHours groupMemberHours){
        return new GroupMemberHoursDto(
            groupMemberHours.getGroupMember().getGroupMemberId(),
                groupMemberHours.getGroupMember().getGroupMemberName(),
                groupMemberHours.getWeek().getId(),

                groupMemberHours.getWeek().getWeekNumber(),
                groupMemberHours.getHours()


        );
    }
}
