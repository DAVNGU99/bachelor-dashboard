package com.example.dashboardapp.dto;

import com.example.dashboardapp.domain.entities.BoardColumn;
import com.example.dashboardapp.domain.entities.Task;

import java.util.List;

public record ColumnDto(
        Long id,
        String key,
        String title,
        int position,
        List<TaskDto> tasks
) {

    public static ColumnDto from(BoardColumn column, List<Task> tasks){
        return new ColumnDto(
                column.getId(),
                column.getKey(),
                column.getTitle(),
                column.getPosition(),
                tasks.stream().map(TaskDto::from).toList()
        );
    }

}
