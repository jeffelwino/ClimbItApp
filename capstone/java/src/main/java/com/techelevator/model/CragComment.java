package com.techelevator.model;

import java.time.LocalDate;

public class CragComment extends Comment{
    private String cragId;

    public CragComment() {}

    public CragComment(int commentId, String body, int profileId, LocalDate postDate, String cragId) {
        super(commentId, body, profileId, postDate);
        this.cragId = cragId;
    }

    public String getCragId() {
        return cragId;
    }

    public void setCragId(String cragId) {
        this.cragId = cragId;
    }

    @Override
    public String toString() {
        return "CragComment{" +
                "cragId='" + cragId + '\'' +
                '}';
    }
}
