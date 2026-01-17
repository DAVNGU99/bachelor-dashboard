package com.example.dashboardapp.controllers;

import com.example.dashboardapp.domain.entities.hourlogger.GroupMemberHours;
import com.example.dashboardapp.dto.hourlogger.GroupMemberHoursDto;
import com.example.dashboardapp.services.hourlogger.GroupMemberHoursService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hourlogger")
public class HourLoggerController {

    private  final GroupMemberHoursService groupMemberHoursService;


    public HourLoggerController(GroupMemberHoursService groupMemberHoursService) {
        this.groupMemberHoursService = groupMemberHoursService;
    }

    @GetMapping("/week/{weekNumber}")
    public Page<GroupMemberHoursDto>getByWeek(@PathVariable Integer weekNumber, Pageable pageable){
       return groupMemberHoursService.getHoursForAGivenWeek(weekNumber, pageable).map(GroupMemberHoursDto::from);
    }

}
