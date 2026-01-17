package com.example.dashboardapp.domain.entities.hourlogger;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "weeks")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Week {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer weekNumber;

    public Week(Integer weekNumber){
        this.weekNumber = weekNumber;
    }

    public void update(Integer weekNumber){
        this.weekNumber = weekNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Week weeks = (Week) o;
        return Objects.equals(id, weeks.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
