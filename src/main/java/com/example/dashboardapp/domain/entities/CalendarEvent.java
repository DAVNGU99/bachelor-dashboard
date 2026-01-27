package com.example.dashboardapp.domain.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "calendar_events")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "start_time")
    private Instant startTime;

    @Column(nullable = false, name = "end_time")
    private Instant endTime;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private Instant createdAt;

    public CalendarEvent(String title, Instant startTime, Instant endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void update(String title, Instant startTime, Instant endTime){

        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEvent that = (CalendarEvent) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

