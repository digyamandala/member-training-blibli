package com.company.memberapp.service;

import com.company.memberapp.Member;

import java.util.List;

public interface MemberService {
    Member create(Member member);
    Member update(Member member);
    Member delete(String id);
    Member findById(String id);
    List<Member> findAll();
}
