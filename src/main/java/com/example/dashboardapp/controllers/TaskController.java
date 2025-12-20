package com.example.dashboardapp.controllers;


import com.example.dashboardapp.domain.entities.Task;
import com.example.dashboardapp.dto.CreateTaskRequest;
import com.example.dashboardapp.dto.TaskDto;
import com.example.dashboardapp.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kanban/tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TaskDto createTask(@RequestBody CreateTaskRequest taskRequest){

    Task task = taskService.createTask(
            taskRequest.columnId(),
            taskRequest.title(),
            taskRequest.description()
    );

    return TaskDto.from(task);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{taskId}/move")
    public void moveTask(@PathVariable Long taskId, @RequestParam Long targetColumnId){
        taskService.moveTask(taskId, targetColumnId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{taskId}")
    public void updateTask(@PathVariable Long taskId, @RequestBody CreateTaskRequest taskRequest){

        taskService.updateTask(
                taskId,
                taskRequest.title(),
                taskRequest.description()
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }

    @GetMapping("/column/{columnId}")
    public List<TaskDto> getTasksForColumn(@PathVariable Long columnId) {

        return taskService.getTasksForColumn(columnId)
                .stream()
                .map(TaskDto::from)
                .toList();
    }


}
