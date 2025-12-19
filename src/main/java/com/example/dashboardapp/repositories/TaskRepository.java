package com.example.dashboardapp.repositories;

import com.example.dashboardapp.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    



}
