package com.example.dashboardapp.services;

import com.example.dashboardapp.domain.entities.MeetingDate;
import com.example.dashboardapp.repositories.MeetingDateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeetingDateService {

    private final MeetingDateRepository meetingDateRepository;


    public MeetingDateService(MeetingDateRepository meetingDateRepository) {
        this.meetingDateRepository = meetingDateRepository;
    }


    public MeetingDate findMeetingWithId(Long id) {

        return meetingDateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Kunne ikke finne møte med denne id" + id));

    }

    public List<MeetingDate> findAllMeetings(){
       return  meetingDateRepository.findAll();
    }

    @Transactional
    public void updateMeeting(Long id, LocalDateTime time, String description){
        MeetingDate meetingDate = findMeetingWithId(id);
        meetingDate.update(time,description);

    }











}
