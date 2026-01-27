package com.example.dashboardapp.repositories;

import com.example.dashboardapp.domain.entities.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
}
