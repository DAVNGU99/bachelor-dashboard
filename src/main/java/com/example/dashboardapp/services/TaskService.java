package com.example.dashboardapp.services;


import com.example.dashboardapp.domain.entities.BoardColumn;
import com.example.dashboardapp.domain.entities.Task;
import com.example.dashboardapp.repositories.BoardColumnRepository;
import com.example.dashboardapp.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    @Transactional
    public List<Task> getTasksForColumn(Long columnId){
        return taskRepository.findByBoardColumnIdOrderByPosition(columnId);
    }



    @Transactional
    public void moveTask(Long taskId, Long targetColumnId){

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Kunne ikke finne task"));

        BoardColumn targetColumn = boardColumnRepository.findById(targetColumnId)
                .orElseThrow(() -> new IllegalArgumentException("Kunne ikke finne kolonne"));


        int newPosition = taskRepository.countByBoardColumnId(targetColumnId);

        task.moveTo(targetColumn, newPosition);

    }

    @Transactional
    public void updateTask(Long taskId, String title, String description){

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Kunne ikke finne task"));


        task.update(title, description);
    }

    @Transactional
    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }



}
