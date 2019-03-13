package com.company.memberapp.entity;

import com.company.memberapp.validation.EmailUnique;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "members")
public class Member {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    @EmailUnique
    private String email;

    @NotBlank
    private String password;


    @NotBlank
    private String gender;


    @NotBlank
    private String address;

}
