package com.example.dashboardapp.dto;

import java.time.LocalDateTime;

public record UpdateMeetingRequest(LocalDateTime time, String description) {
}
