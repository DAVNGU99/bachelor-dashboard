package com.example.dashboardapp.domain.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "oblig")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Oblig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private boolean finished;

    public Oblig(String title){
        this.title=title;
        this.finished=false;
    }

    public Oblig(String title, boolean finished){
        this.title=title;
        this.finished=finished;
    }

    public void markFinished(){
        this.finished = true;
    }

    public void toggleFinished() {
        this.finished = !this.finished;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Oblig oblig = (Oblig) o;
        return Objects.equals(id, oblig.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
