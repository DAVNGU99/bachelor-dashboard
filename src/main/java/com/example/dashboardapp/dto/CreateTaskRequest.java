package com.example.dashboardapp.dto;

public record CreateTaskRequest(
        Long columnId,
        String title,
        String description
) {
}
