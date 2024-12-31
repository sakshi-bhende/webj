package com.cdac.entity;

import com.cdac.entity.enums.Category;
import com.cdac.entity.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="requesterphonenumber")
    private String requesterPhoneNumber;

    @Column(name="category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name="issuedetails")
    private String issueDetails;

    @Column(name="resolutiondetails")
    private String resolutionDetails;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="createddatetime")
    private LocalDateTime createdDateTime;

    @Column(name="resolutiondatetime")
    private LocalDateTime resolutionDateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequesterPhoneNumber() {
        return requesterPhoneNumber;
    }

    public void setRequesterPhoneNumber(String requesterPhoneNumber) {
        this.requesterPhoneNumber = requesterPhoneNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIssueDetails() {
        return issueDetails;
    }

    public void setIssueDetails(String issueDetails) {
        this.issueDetails = issueDetails;
    }

    public String getResolutionDetails() {
        return resolutionDetails;
    }

    public void setResolutionDetails(String resolutionDetails) {
        this.resolutionDetails = resolutionDetails;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getResolutionDateTime() {
        return resolutionDateTime;
    }

    public void setResolutionDateTime(LocalDateTime resolutionDateTime) {
        this.resolutionDateTime = resolutionDateTime;
    }
}
