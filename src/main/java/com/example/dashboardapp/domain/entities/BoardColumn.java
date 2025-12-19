package com.example.dashboardapp.domain.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board_columns")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String key;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private int position;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id")
    private Board board;

    public BoardColumn(String key, String title, int position, Board board) {
        this.key = key;
        this.title = title;
        this.position = position;
        this.board = board;
    }
}
