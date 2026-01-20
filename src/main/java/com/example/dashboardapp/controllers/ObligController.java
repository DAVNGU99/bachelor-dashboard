package com.example.dashboardapp.controllers;

import com.example.dashboardapp.domain.entities.Oblig;
import com.example.dashboardapp.dto.ObligDto;
import com.example.dashboardapp.services.ObligService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oblig")
public class ObligController {

    private final ObligService obligService;

    public ObligController(ObligService obligService){
        this.obligService = obligService;
    }

    @GetMapping
    public ResponseEntity<List<ObligDto>> getAllObligs(){

        List<Oblig> list = obligService.getAllObligs();

        List<ObligDto> toDto = ObligDto.from(list);

        return ResponseEntity.ok(toDto);

    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Void> checkBoolean(@PathVariable Long id){

        obligService.toggleDone(id);

        return ResponseEntity.noContent().build();

    }

}
