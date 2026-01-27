package com.example.dashboardapp.dto;

import java.time.Instant;

public record CalendarEventRequest(
        String title,
        Instant startTime,
        Instant endTime
){}
