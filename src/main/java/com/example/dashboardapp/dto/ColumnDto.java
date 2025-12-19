package com.example.dashboardapp.dto;

import java.util.List;

public record ColumnDto(
        String key,
        String title,
        int position,
        List<TaskDto> tasks
) {
}
