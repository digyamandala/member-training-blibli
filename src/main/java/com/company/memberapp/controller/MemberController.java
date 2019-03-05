package com.company.memberapp.controller;

import com.company.memberapp.Member;
import com.company.memberapp.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @RequestMapping(
            value = "/members",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member create(@RequestBody Member mb){

        return memberService.create(mb);
    }

    @RequestMapping(
            value = "/members/{idMember}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member findById(@PathVariable("idMember") String id){

        return memberService.findById(id);
    }


    @RequestMapping(
            value = "/members",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @RequestMapping(
            value = "/member/{idMember}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member delete(@PathVariable("idMember") String id){
        return memberService.delete(id);
    }

    @RequestMapping(
            value = "/members/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member update(@RequestBody Member mb){
        return memberService.update(mb);
    }
}
