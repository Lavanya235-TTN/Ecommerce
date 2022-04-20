package com.learn.project.Bootcamp.Project.dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private boolean isDeleted;
    private boolean isActive;
    private boolean isExpired;
    private boolean isLocked;
    private int invalidAttempCount;
    private String passwordUpdateDate;
//
//    private String gst;
//    private BigInteger companyContact;
//    private String companyName;
//
//
//    private String contact;

    public UserDto(){
        this.setDeleted(Boolean.FALSE);
        this.setExpired(false);
        this.setLocked(true);
        this.setInvalidAttempCount(0);
        this.setPasswordUpdateDate("today");
        this.setActive(false);
        this.setDeleted(false);

    }

	public UserDto(String email, String firstName, String middleName, String lastName, String password) {
		this.email = email;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public int getInvalidAttempCount() {
		return invalidAttempCount;
	}

	public void setInvalidAttempCount(int invalidAttempCount) {
		this.invalidAttempCount = invalidAttempCount;
	}

	public String getPasswordUpdateDate() {
		return passwordUpdateDate;
	}

	public void setPasswordUpdateDate(String passwordUpdateDate) {
		this.passwordUpdateDate = passwordUpdateDate;
	}

    

}
