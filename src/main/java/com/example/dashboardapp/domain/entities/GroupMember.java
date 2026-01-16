package com.example.dashboardapp.domain.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

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
        if (o == null || getClass() != o.getClass()) return false;
        GroupMember that = (GroupMember) o;
        return groupMemberId == that.groupMemberId;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
