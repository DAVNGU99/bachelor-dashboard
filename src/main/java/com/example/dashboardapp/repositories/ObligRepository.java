package com.example.dashboardapp.repositories;

import com.example.dashboardapp.domain.entities.Oblig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObligRepository extends JpaRepository<Oblig,Long> {
}
