package com.example.dashboardapp.dto;

import com.example.dashboardapp.domain.entities.Oblig;

import java.util.List;

public record ObligDto(Long id, String title, boolean finished) {

    public static ObligDto from(Oblig oblig) {
        return new ObligDto(
                oblig.getId(),
                oblig.getTitle(),
                oblig.isFinished()
        );
    }

    public static List<ObligDto> from(List<Oblig> obligs) {
        return obligs.stream().map(ObligDto::from).toList();
    }
}

