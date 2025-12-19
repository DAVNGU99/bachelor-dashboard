package com.example.dashboardapp.repositories;

import com.example.dashboardapp.domain.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
