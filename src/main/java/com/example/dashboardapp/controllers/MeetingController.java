package com.example.dashboardapp.controllers;

import com.example.dashboardapp.domain.entities.MeetingDate;
import com.example.dashboardapp.dto.MeetingDateDto;
import com.example.dashboardapp.dto.UpdateMeetingRequest;
import com.example.dashboardapp.services.MeetingDateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    private final MeetingDateService meetingDateService;

    public MeetingController(MeetingDateService meetingDateService){
        this.meetingDateService = meetingDateService;
    }

    @GetMapping("/{meetingId}")
    public ResponseEntity<MeetingDateDto> getMeetingById(@PathVariable Long meetingId){

        MeetingDate meetingDate = meetingDateService.findMeetingWithId(meetingId);

        MeetingDateDto meetingDateDto = MeetingDateDto.from(meetingDate);

        return ResponseEntity.ok(meetingDateDto);
    }

    @PatchMapping("/{meetingId}")
    public ResponseEntity<Void> updateMeeting(@PathVariable Long meetingId, @RequestBody UpdateMeetingRequest updateMeetingRequest){


      meetingDateService.updateMeeting(
              meetingId,
              updateMeetingRequest.time(),
              updateMeetingRequest.description()
      );
    return  ResponseEntity.ok().build();
    }






}
