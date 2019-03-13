package com.company.memberapp.service;

import com.company.memberapp.entity.Member;
import com.company.memberapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MemberServiceImpl implements MemberService{

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public Mono<Member> create(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Mono<Member> update(Member member) {
        Mono<Member> memberMono = memberRepository.findById(member.getId());
        if(memberMono != null){
            return memberRepository.save(member);
        }
        return null;
    }

    @Override
    public Mono<Member> delete(String id) {
        return memberRepository.removeMemberById(id);
    }

    @Override
    public Mono<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public Flux<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Mono<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public Flux<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

}
