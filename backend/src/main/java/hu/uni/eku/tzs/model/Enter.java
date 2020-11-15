package hu.uni.eku.tzs.model;

import java.util.Date;

public class Enter {
    private String name;
    private int age;
    private boolean allowed;
    private Date Date;

    public Enter(String name, int age, java.util.Date date) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        this.Date = date;
    }
}
