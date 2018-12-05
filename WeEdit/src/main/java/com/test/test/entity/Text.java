package com.test.test.entity;

import java.util.Date;

public class Text {

    private Integer textId;
    private String textTitle;
    private Date textDate;
    private Date textUpdateDate;
    private int textAuthorId;

    public Date getTextUpdateDate() {
        return textUpdateDate;
    }

    public void setTextUpdateDate(Date textUpdateDate) {
        this.textUpdateDate = textUpdateDate;
    }

    public Integer getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public Date getTextDate() {
        return textDate;
    }

    public void setTextDate(Date textDate) {
        this.textDate = textDate;
    }

    public int getTextAuthorId() {
        return textAuthorId;
    }

    public void setTextAuthorId(int textAuthorId) {
        this.textAuthorId = textAuthorId;
    }
}
