package com.example.dashboardapp.repositories.hourlogger;

import com.example.dashboardapp.domain.entities.hourlogger.Week;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekRepository extends JpaRepository<Week,Integer> {
}
