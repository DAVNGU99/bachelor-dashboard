package com.example.dashboardapp.services;

import com.example.dashboardapp.domain.entities.Oblig;
import com.example.dashboardapp.repositories.ObligRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ObligService {

    private final ObligRepository obligRepository;

    public ObligService(ObligRepository obligRepository){
        this.obligRepository=obligRepository;
    }


    public List<Oblig> getAllObligs(){
        return obligRepository.findAll();
    }

    @Transactional
    public void toggleDone(Long id){

        Oblig oblig = obligRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Kunne ikke finne noen med denne ID" + id));

        oblig.toggleFinished();
    }


}
