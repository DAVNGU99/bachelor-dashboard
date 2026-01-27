package com.example.dashboardapp.services;

import com.example.dashboardapp.domain.entities.CalendarEvent;
import com.example.dashboardapp.repositories.CalendarEventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CalendarEventService {

    private final CalendarEventRepository calendarEventRepository;

    public CalendarEventService(CalendarEventRepository calendarEventRepository){
        this.calendarEventRepository = calendarEventRepository;
    }


    public CalendarEvent getCalendarEventById(Long id){
        return calendarEventRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Kunne ikke finne kalenderevent med id=" + id));
    }

    public List<CalendarEvent> getAllCalendarEvents(){
        return calendarEventRepository.findAll();
    }

    @Transactional
    public void deleteCalendarEventById(Long id){
        calendarEventRepository.deleteById(id);
    }

    @Transactional
    public void updateCalendarEvent(Long id, String title, Instant start, Instant end){
        CalendarEvent existingEvent = getCalendarEventById(id);
        existingEvent.update(title,start,end
        );
    }

    @Transactional
    public CalendarEvent createEvent(String title, Instant start, Instant end) {
        validate(title, start, end);
        return calendarEventRepository.save(new CalendarEvent(title, start, end));
    }

    private void validate(String title, Instant start, Instant end) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Tittel er nødvendig");

        if (start == null || end == null)
            throw new IllegalArgumentException("Starttid og sluttid er nødvendige");

        if (!end.isAfter(start))
            throw new IllegalArgumentException("Sluttid må være etter starttid");
    }


}
