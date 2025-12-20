package com.example.dashboardapp.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 200)
    private String description;

    @Column(nullable = false)
    private int position;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "column_id")
    private BoardColumn boardColumn;


    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Task(String title, String description, int position, BoardColumn column) {
        this.title = title;
        this.description = description;
        this.position = position;
        this.boardColumn = column;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    public void moveTo(BoardColumn newColumn, int newPosition) {
        this.boardColumn = newColumn;
        this.position = newPosition;
    }

    public void update(String title, String description){
        this.title = title;
        this.description = description;
    }



}
