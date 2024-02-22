package com.model;

public class Student {
 private int sid;
 private String sname;
 private String semail;
 private String sub;
 private String gender;
 private String education;
 public Student(int sid, String sname, String semail, String sub, String gender, String education) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.semail = semail;
		this.sub = sub;
		this.gender = gender;
		this.education = education;
	}
public Student(String sname, String semail, String sub, String gender, String education) {
	super();
	this.sname = sname;
	this.semail = semail;
	this.sub = sub;
	this.gender = gender;
	this.education = education;
}

public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSemail() {
	return semail;
}
public void setSemail(String semail) {
	this.semail = semail;
}
public String getSub() {
	return sub;
}
public void setSub(String sub) {
	this.sub = sub;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
 
 
 
}
