package com.validate.model;

import com.validate.validate.annotation.Request;
import com.validate.validate.annotation.Required;

/**
 * Created by wanghongxing on 15/10/10.
 */
@Request
public class DemoModel{

    @Required
    private Integer id;
    @Required
    private String name;
    @Required
    private String password;
    private String startTime;
    private String endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
