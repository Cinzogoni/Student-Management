package model;

import java.time.LocalDate;

public class Student extends Person {
    private String classId;
    private String studentRole;
    private double gpa;

    public Student() {
    }

    public Student(String classId, String studentRole, double gpa, String id, String name, LocalDate dob, String phone, String email) {
        super(id, name, dob, phone, email);
        this.classId = classId;
        this.studentRole = studentRole;
        this.gpa = gpa;
    }

    public String getClassId() {
        return classId;
    }

    public String getStudentRole() {
        return studentRole;
    }

    public double getGpa() {
        return gpa;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setStudentRole(String studentRole) {
        this.studentRole = studentRole;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + classId + " - " + studentRole + " - " + gpa;
    }
}
