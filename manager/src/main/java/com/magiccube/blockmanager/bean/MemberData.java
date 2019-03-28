package com.magiccube.blockmanager.bean;

import com.magiccube.blockmanager.model.Member;

import java.util.List;

public class MemberData extends BaseData {
    private List<Member> members;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
