package com.qiang.pojo;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer commentUserId;

    private Integer commentGoodsId;

    private String commentContent;

    private Date commentDate;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public Integer getCommentGoodsId() {
        return commentGoodsId;
    }

    public void setCommentGoodsId(Integer commentGoodsId) {
        this.commentGoodsId = commentGoodsId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}