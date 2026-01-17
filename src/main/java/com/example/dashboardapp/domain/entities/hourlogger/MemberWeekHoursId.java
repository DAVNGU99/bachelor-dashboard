package com.example.dashboardapp.domain.entities.hourlogger;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberWeekHoursId implements Serializable {


    private Integer groupMemberId;
    private Integer weekId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberWeekHoursId that = (MemberWeekHoursId) o;
        return Objects.equals(groupMemberId, that.groupMemberId) && Objects.equals(weekId, that.weekId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupMemberId, weekId);
    }
}
