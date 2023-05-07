package com.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(setterPrefix = "set")
@Getter
public class Employee {

    private String fname;
    private String lname;
    private int id;
    private String email;

}
