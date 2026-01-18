package com.example.dashboardapp.repositories.hourlogger;

import com.example.dashboardapp.domain.entities.hourlogger.Week;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface WeekRepository extends JpaRepository<Week,Integer> {
    Optional<Week> findByWeekNumber(Integer weekNumber);
}
