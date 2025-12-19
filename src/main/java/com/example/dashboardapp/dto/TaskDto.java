package com.example.dashboardapp.dto;

public record TaskDto(
    Long id,
    String title,
    String description,
    int position){
}

