package com.company.memberapp.repository;

import com.company.memberapp.entity.Member;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberRepository extends ReactiveMongoRepository<Member, String> {
    Mono<Member> save(Member member);
    Flux<Member> findByName(String name);
    Mono<Member> findByEmail(String email);
    Mono<Member> removeMemberById(String id);
}
