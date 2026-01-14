package com.example.dashboardapp.domain.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "meeting_dates")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeetingDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private LocalDateTime time;


    @Column(length = 150, nullable = true)
    private String description;

    public MeetingDate( LocalDateTime time, String description) {
        this.time = time;
        this.description = description;
    }

    public void update(LocalDateTime time, String description){
        this.time = time;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeetingDate)) return false;
        MeetingDate that = (MeetingDate) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
