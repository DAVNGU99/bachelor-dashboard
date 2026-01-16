package com.example.dashboardapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UpdateMeetingRequest(
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime time,
        String description
) {}
