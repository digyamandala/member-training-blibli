package com.company.memberapp.validation;

import com.company.memberapp.entity.Member;
import com.company.memberapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Custom Validator , email harus blibli.com
//Harus bikin anotasi, kalo mau bikin custom validator

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

    private MemberRepository memberRepository;

    @Autowired
    public EmailUniqueValidator(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        Member member= memberRepository.findByEmail(value).block();
        return member == null;
    }
}
