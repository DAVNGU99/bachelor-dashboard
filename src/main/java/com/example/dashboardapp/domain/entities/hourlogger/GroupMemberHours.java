package com.example.dashboardapp.domain.entities.hourlogger;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "group_member_hours",
        uniqueConstraints = @UniqueConstraint(columnNames = {"group_member_id", "week_id"})
)
public class GroupMemberHours {


    @EmbeddedId
    private MemberWeekHoursId id;

    @MapsId("groupMemberId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_member_id", nullable = false)
    private GroupMember groupMember;


    @MapsId("weekId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "week_id", nullable = false)
    private Week week;

    @Column(nullable = false)
    private int hours;

    public GroupMemberHours(GroupMember groupMember, Week week){
        this.groupMember = groupMember;
        this.week = week;
        this.id = new MemberWeekHoursId(groupMember.getGroupMemberId(), week.getId());
        this.hours = 0;
    }

    public void increment(){
        this.hours += 1;
    }

    public void decrement(){
        if(this.hours >0) this.hours-=1;
    }

    public void setHours(int hours){
        if(hours <0 )throw new IllegalArgumentException("Kan ikke ha timer under 0");
        this.hours=hours;
    }










}
