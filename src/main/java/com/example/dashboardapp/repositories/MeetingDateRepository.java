package com.example.dashboardapp.repositories;



import com.example.dashboardapp.domain.entities.MeetingDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingDateRepository extends JpaRepository<MeetingDate, Long> {



}
