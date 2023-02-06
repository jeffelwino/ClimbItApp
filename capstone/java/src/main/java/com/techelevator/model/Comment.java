package com.techelevator.model;

import java.time.LocalDate;

public class Comment {
    private int commentId;
    private String body;
    private int profileId;
    private LocalDate postDate;
    private String subjectId;

    public Comment() {
    }

    public Comment(int commentId, String body, int profileId, LocalDate postDate, String subjectId) {
        this.commentId = commentId;
        this.body = body;
        this.profileId = profileId;
        this.postDate = postDate;
        this.subjectId = subjectId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", body='" + body + '\'' +
                ", profileId=" + profileId +
                ", postDate=" + postDate +
                ", subjectId='" + subjectId + '\'' +
                '}';
    }
}
