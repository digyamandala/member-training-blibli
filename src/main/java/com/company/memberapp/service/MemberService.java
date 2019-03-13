package com.company.memberapp.service;

import com.company.memberapp.entity.Member;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface MemberService {
    Mono<Member> create(Member member);
    Mono<Member> update(Member member);
    Mono<Member> delete(String id);
    Mono<Member> findById(String id);
    Flux<Member> findAll();
    Mono<Member> findByEmail(String email);
    Flux<Member> findByName(String name);
}
