package com.company.memberapp.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationHelper {

    private Validator validator;

    @Autowired
    public ValidationHelper(Validator validator) {
        this.validator = validator;
    }


    public <T> Mono<T> validate(T request){
        return Mono.fromSupplier( () -> {

            Set<ConstraintViolation<T> > violationSet = validator.validate(request);

            if(violationSet.isEmpty()){
                return request;
            }
            else{
                throw new IllegalArgumentException("Doesnt pass the validation");
            }
        });
    }
}
