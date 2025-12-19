package com.example.dashboardapp.repositories;

import com.example.dashboardapp.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByColumnIdOrderByPosition(Long columnId);




}
