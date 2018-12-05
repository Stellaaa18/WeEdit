package com.test.test.entity;

import java.util.Date;

public class TextComment {
    private Integer commentId;
    private String commentContent;
    private Date commentDate;
    private String commentEditorId;
    private Integer textId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentEditorId() {
        return commentEditorId;
    }

    public void setCommentEditorId(String commentEditorId) {
        this.commentEditorId = commentEditorId;
    }

    public Integer getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }
}
