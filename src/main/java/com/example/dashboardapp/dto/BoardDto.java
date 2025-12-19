package com.example.dashboardapp.dto;

import java.util.List;

public record BoardDto(Long id, String title, List<ColumnDto> columns1) {
}
