package com.example.dashboardapp.services;


import com.example.dashboardapp.domain.entities.BoardColumn;
import com.example.dashboardapp.domain.entities.Task;
import com.example.dashboardapp.repositories.BoardColumnRepository;
import com.example.dashboardapp.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;
    private final BoardColumnRepository boardColumnRepository;


    public TaskService(TaskRepository taskRepository, BoardColumnRepository boardColumnRepository) {
        this.taskRepository = taskRepository;
        this.boardColumnRepository = boardColumnRepository;
    }

    @Transactional
    public Task createTask(Long columnId, String title, String description) {

        BoardColumn column = boardColumnRepository.findById(columnId)
                .orElseThrow(() -> new IllegalArgumentException("Column not found"));

        int position = taskRepository.countByBoardColumnId(columnId);

        Task task = new Task(title, description, position, column);

        return taskRepository.save(task);
    }



}
