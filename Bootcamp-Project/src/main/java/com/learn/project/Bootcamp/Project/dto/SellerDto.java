package com.learn.project.Bootcamp.Project.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class SellerDto extends UserDto{

    private String gst;
    private BigInteger companyContact;
    private String companyName;

}
