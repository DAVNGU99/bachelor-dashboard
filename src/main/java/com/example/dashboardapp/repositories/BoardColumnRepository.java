package com.example.dashboardapp.repositories;

import com.example.dashboardapp.domain.entities.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {


}
