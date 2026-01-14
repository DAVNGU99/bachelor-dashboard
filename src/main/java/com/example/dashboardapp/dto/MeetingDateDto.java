package com.example.dashboardapp.dto;

import com.example.dashboardapp.domain.entities.MeetingDate;

import java.time.LocalDateTime;

public record MeetingDateDto(Long id,
                             LocalDateTime time,
                             String description) {


    public static MeetingDateDto from (MeetingDate meetingDate) {
        return new MeetingDateDto(meetingDate.getId(),
                meetingDate.getTime(),
                meetingDate.getDescription()

        );
    }
}
