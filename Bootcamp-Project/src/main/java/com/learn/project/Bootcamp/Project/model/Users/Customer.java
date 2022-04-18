package com.learn.project.Bootcamp.Project.model.Users;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "customer_id",referencedColumnName = "id")
public class Customer extends User {

    public Customer(){
        super();
    }

    private String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
