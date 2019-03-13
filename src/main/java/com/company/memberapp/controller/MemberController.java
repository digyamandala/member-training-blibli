package com.company.memberapp.controller;

import com.company.memberapp.entity.ApiKey;
import com.company.memberapp.entity.Member;
import com.company.memberapp.service.MemberService;
import com.company.memberapp.validation.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class MemberController {

    private MemberService memberService;
    private ValidationHelper validationHelper;

    @Autowired
    public MemberController(MemberService memberService, ValidationHelper validationHelper) {
        this.memberService = memberService;
        this.validationHelper = validationHelper;
    }

    @RequestMapping(
            value = "/members",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> create(@RequestBody Member mb, ApiKey apiKey){

        return validationHelper.validate(mb)
                .flatMap( data -> memberService.create(mb))
                .subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/members/{idMember}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> findById(@PathVariable("idMember") String id, ApiKey apiKey){

        return memberService.findById(id)
                .subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/members/{memberName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Member> findByName(@PathVariable("memberName") String memberName, ApiKey apiKey){

        return memberService.findByName(memberName)
                .subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/members/{memberEmail}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> findByEmail(@PathVariable("memberEmail") String memberEmail, ApiKey apiKey){

        return memberService.findByEmail(memberEmail)
                .subscribeOn(Schedulers.elastic());
    }


    @RequestMapping(
            value = "/members",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Member> findAll(ApiKey apiKey) {
        return memberService.findAll()
                .subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/members/{idMember}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> delete(@PathVariable("idMember") String id, ApiKey apiKey){
        return memberService.delete(id)
                .subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/members/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> update(@RequestBody Member mb, ApiKey apiKey) {
        return validationHelper.validate(mb)
                .flatMap( data -> memberService.update(mb))
                .subscribeOn(Schedulers.elastic());

    }
}
