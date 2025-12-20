package com.example.dashboardapp.dto;

import com.example.dashboardapp.domain.entities.Task;

public record TaskDto(
        Long id,
        String title,
        String description,
        int position,
        Long columnId
) {
    public static TaskDto from(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPosition(),
                task.getBoardColumn().getId()
        );
    }
}
