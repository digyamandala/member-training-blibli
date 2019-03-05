package com.company.memberapp.service;

import com.company.memberapp.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberServiceImpl implements MemberService{
    private ArrayList<Member> members = new ArrayList<>();

    @Override
    public Member create(Member member) {
        members.add(member);
        return member;
    }

    @Override
    public Member update(Member member) {
        for(int i = 0 ; i < members.size() ; i++) {
            if(members.get(i).getUserid().equals(member.getUserid())) {
                members.set(i, member);
                return members.get(i);
            }
        }
        return null;
    }

    @Override
    public Member delete(String id) {
        Member curr;
        for(int i = 0 ; i < members.size() ; i++) {
            curr = members.get(i);
            if(id.equals(curr.getUserid())) {
                members.remove(curr);
                return curr;
            }
        }
        return null;
    }

    @Override
    public Member findById(String id) {
        for(int i = 0 ; i < members.size() ; i++) {
            if(id.equals(members.get(i).getUserid())) {
                return members.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return members;
    }
}
