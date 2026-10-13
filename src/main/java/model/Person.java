package model;

import java.time.LocalDate;
import utils.Validates;

public abstract class Person {
    protected String id;
    protected String name;
    protected LocalDate dob;
    protected String phone;
    protected String email;

    public Person() {
    }

    
    public Person(String id, String name, LocalDate dob, String phone, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String dobStr = (dob == null) ? "N/A" : dob.format(Validates.FMT);
        return id + " - " + name + " - " + dobStr + " - " + phone + " - " + email;
    } 
}
