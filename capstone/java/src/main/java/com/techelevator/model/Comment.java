package com.techelevator.model;

import java.time.LocalDate;

public abstract class Comment {
    private int commentId;
    private String body;
    private int profileId;
    private LocalDate postDate;

    public Comment() {
    }

    public Comment(int commentId, String body, int profileId, LocalDate postDate) {
        this.commentId = commentId;
        this.body = body;
        this.profileId = profileId;
        this.postDate = postDate;
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

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", body='" + body + '\'' +
                ", profileId=" + profileId +
                ", postDate=" + postDate +
                '}';
    }
}
