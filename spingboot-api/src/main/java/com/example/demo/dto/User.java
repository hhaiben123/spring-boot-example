package com.example.demo.dto;

import java.io.Serializable;

/**
 * Created by hhb on 2017/8/5.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -764469990687573068L;
    private String userName;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
