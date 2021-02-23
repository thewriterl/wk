package wk.technology.test.imccalc.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorGeneric {
    private String title;
    private String detail;
    @JsonIgnore
    private String type;
    private String status;
    private String instance;


    public ErrorGeneric(){}

    public ErrorGeneric(String title, String detail, String type, String status, String instance) {
        this.title = title;
        this.detail = detail;
        this.type = type;
        this.status = status;
        this.instance = instance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}
