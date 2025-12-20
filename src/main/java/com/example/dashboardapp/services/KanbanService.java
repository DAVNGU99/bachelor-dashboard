package com.example.dashboardapp.services;


import com.example.dashboardapp.domain.entities.Board;
import com.example.dashboardapp.domain.entities.BoardColumn;
import com.example.dashboardapp.domain.entities.Task;
import com.example.dashboardapp.dto.BoardDto;
import com.example.dashboardapp.dto.ColumnDto;
import com.example.dashboardapp.repositories.BoardColumnRepository;
import com.example.dashboardapp.repositories.BoardRepository;
import com.example.dashboardapp.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class KanbanService {

    private static final int COLUMN_COUNT = 4;
    private final BoardRepository boardRepository;
    private final BoardColumnRepository boardColumnRepository;
    private final TaskRepository taskRepository;


    public KanbanService(BoardRepository boardRepository, BoardColumnRepository boardColumnRepository, TaskRepository taskRepository){
        this.boardRepository = boardRepository;
        this.boardColumnRepository = boardColumnRepository;
        this.taskRepository = taskRepository;
    }



    public BoardDto getBoard(){
        Board board = boardRepository.findAll().
                stream().
                findFirst().orElseThrow(() -> new IllegalStateException("Kanbanboard ikke initializaed"));

        List<BoardColumn> columns =
                boardColumnRepository.findByBoardIdOrderByPosition(board.getId());

        if(columns.size() != COLUMN_COUNT){
            throw new IllegalStateException("Kanban må ha akkurat" + COLUMN_COUNT + "kolonner");
        }

        List<ColumnDto>  columnDtos = new ArrayList<>();

        for(BoardColumn column : columns){
            List<Task> tasks =
                    taskRepository.findByBoardColumnIdOrderByPosition(column.getId());
                columnDtos.add(ColumnDto.from(column,tasks));

        }

        return new BoardDto(board.getId(), board.getTitle(), columnDtos);


    }


    //hjelpemetode

    private ColumnDto toColumnDto(BoardColumn column) {
        return new ColumnDto(
                column.getKey(),
                column.getTitle(),
                column.getPosition(),
                List.of() //
        );
    }
}

