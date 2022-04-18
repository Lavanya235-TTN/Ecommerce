package com.learn.project.Bootcamp.Project.model.Users;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigInteger;
@Entity
@PrimaryKeyJoinColumn(name = "seller_id",referencedColumnName = "id")
public class Seller extends User {

    private String gst;
    private BigInteger companyContact;
    private String companyName;

    public Seller() {
        super();
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public BigInteger getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(BigInteger companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


}
