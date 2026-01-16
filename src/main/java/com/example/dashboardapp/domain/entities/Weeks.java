package com.example.dashboardapp.domain.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "weeks")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Weeks {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer weekNumber;

    public Weeks(Integer weekNumber){
        this.weekNumber = weekNumber;
    }

    public void update(Integer weekNumber){
        this.weekNumber = weekNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Weeks weeks = (Weeks) o;
        return Objects.equals(id, weeks.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
