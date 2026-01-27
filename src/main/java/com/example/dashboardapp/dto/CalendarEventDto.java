package com.example.dashboardapp.dto;

import com.example.dashboardapp.domain.entities.CalendarEvent;

import java.time.Instant;
import java.util.List;

public record CalendarEventDto(Long id, String title, Instant startTime, Instant endTime) {


    public static CalendarEventDto from(CalendarEvent calendarEvent){

        return new CalendarEventDto(
                calendarEvent.getId(),
                calendarEvent.getTitle(),
                calendarEvent.getStartTime(),
                calendarEvent.getEndTime()
        );

    }

    public static List<CalendarEventDto> from(List<CalendarEvent> list){
        return list.stream()
                .map(CalendarEventDto::from)
                .toList();
    }


}
