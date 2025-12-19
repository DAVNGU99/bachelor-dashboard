package com.example.dashboardapp.repositories;

import com.example.dashboardapp.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {



}
