package com.example.dashboardapp.dto;

import com.example.dashboardapp.domain.entities.MeetingDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record MeetingDateDto(Long id,
                             @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
                             LocalDateTime time,
                             String description) {


    public static MeetingDateDto from (MeetingDate meetingDate) {
        return new MeetingDateDto(meetingDate.getId(),
                meetingDate.getTime(),
                meetingDate.getDescription()

        );
    }

    public static List<MeetingDateDto> from(List<MeetingDate> list){
        return list.stream()
                .map(MeetingDateDto::from)
                .toList();
    }
}
