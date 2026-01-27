package com.example.dashboardapp.controllers;
import com.example.dashboardapp.domain.entities.CalendarEvent;
import com.example.dashboardapp.dto.CalendarEventDto;
import com.example.dashboardapp.dto.CalendarEventRequest;
import com.example.dashboardapp.services.CalendarEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendar/events")
public class CalendarEventController {

    private final CalendarEventService calendarEventService;

    public CalendarEventController(CalendarEventService calendarEventService){
        this.calendarEventService = calendarEventService;
    }

    @GetMapping
    public ResponseEntity<List<CalendarEventDto>> getCalendarEvents (){

        List<CalendarEvent> list = calendarEventService.getAllCalendarEvents();

        List<CalendarEventDto> listToDto = CalendarEventDto.from(list);

        return ResponseEntity.ok(listToDto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CalendarEventDto> getCalendarEvent(@PathVariable Long id){
        CalendarEvent calendarEvent = calendarEventService.getCalendarEventById(id);

        CalendarEventDto calendarEventDto = CalendarEventDto.from(calendarEvent);

        return ResponseEntity.ok(calendarEventDto);


    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCalendarEvent(@PathVariable Long id, @RequestBody CalendarEventRequest calendarEventRequest){

        calendarEventService.updateCalendarEvent(id,
                calendarEventRequest.title(),
                calendarEventRequest.startTime(),
                calendarEventRequest.endTime()

        );

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendarEvent(@PathVariable Long id){
        calendarEventService.deleteCalendarEventById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CalendarEventDto> createEvent(@RequestBody CalendarEventRequest req){

        CalendarEvent calendarEvent = calendarEventService.createEvent(
                req.title(),
                req.startTime(),
                req.endTime()
        );

        return ResponseEntity.ok(CalendarEventDto.from(calendarEvent));


    }


}
