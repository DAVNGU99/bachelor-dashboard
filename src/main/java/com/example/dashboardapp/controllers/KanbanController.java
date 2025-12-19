package com.example.dashboardapp.controllers;


import com.example.dashboardapp.dto.BoardDto;
import com.example.dashboardapp.services.KanbanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kanban")
public class KanbanController {


    private final KanbanService kanbanService;


    public KanbanController(KanbanService kanbanService) {
        this.kanbanService = kanbanService;
    }

    @GetMapping
    public BoardDto getBoard(){
        return  kanbanService.getBoard();
    }



}
