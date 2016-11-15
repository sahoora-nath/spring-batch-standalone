package com.sahoo.spring.batch.standalone.example.model;

import org.joda.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Student")
public class Student {

	private String studentName;
	 
    private LocalDate dob;
 
    private double percentage;
 
    @XmlElement(name = "studentName")
    public String getStudentName() {
        return studentName;
    }
 
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
 
    @XmlElement(name = "dob")
    @XmlJavaTypeAdapter(type = LocalDate.class, value = com.sahoo.spring.batch.standalone.example.batch.LocalDateAdapter.class)
    public LocalDate getDob() {
        return dob;
    }
 
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
 
    @XmlElement(name = "percentage")
    public double getPercentage() {
        return percentage;
    }
 
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
 
    @Override
    public String toString() {
        return "Student [studentName=" + studentName + ", dob=" + dob
                + ", percentage=" + percentage + "]";
    }
}
