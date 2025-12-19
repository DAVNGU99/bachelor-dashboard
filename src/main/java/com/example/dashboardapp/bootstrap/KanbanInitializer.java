package com.example.dashboardapp.bootstrap;


import com.example.dashboardapp.domain.entities.Board;
import com.example.dashboardapp.domain.entities.BoardColumn;
import com.example.dashboardapp.repositories.BoardColumnRepository;
import com.example.dashboardapp.repositories.BoardRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class KanbanInitializer {

    public static final String TODO = "TODO";
    public static final String ACTIVE = "ACTIVE";
    public static final String REVIEW = "REVIEW";
    public static final String DONE = "DONE";


    private final BoardRepository boardRepository;
    private final BoardColumnRepository boardColumnRepository;


    public KanbanInitializer(BoardRepository boardRepository, BoardColumnRepository boardColumnRepository) {
        this.boardRepository = boardRepository;
        this.boardColumnRepository = boardColumnRepository;
    }


    @PostConstruct
    @Transactional
    void init(){
        if(boardRepository.count() == 0 && boardColumnRepository.count() == 0){
            Board board = boardRepository.save(
                    new Board("Bachelor Kanbanboard")
            );

            boardColumnRepository.saveAll(List.of(
                    new BoardColumn(TODO,"Planlagte gjøremål", 0, board),
                    new BoardColumn(ACTIVE,"Aktive gjøremål", 1, board),
                    new BoardColumn(REVIEW,"Gjøremål under vurdering ", 2, board),
                    new BoardColumn(DONE, "Ferdige gjøremål", 3, board)
            ));
        }
    }

}
