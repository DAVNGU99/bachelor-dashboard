package com.example.dashboardapp.domain.entities.hourlogger;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "group_members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupMemberId;

    @Column(nullable = false, unique = true)
    private String groupMemberName;

    public GroupMember(String groupMemberName){
        this.groupMemberName = groupMemberName;
    }

    public void update (String groupMemberName){
        this.groupMemberName = groupMemberName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupMember that = (GroupMember) o;
        return java.util.Objects.equals(groupMemberId, that.groupMemberId);
    }


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
