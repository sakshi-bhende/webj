package com.cdac.dto;



import com.cdac.entity.enums.Category;
import com.cdac.entity.enums.Status;

import java.time.LocalDateTime;

public class TicketDTO {
    private long id;
    private String requesterPhoneNumber;
    private Category category;
    private String issueDetails;
    private String resolutionDetails;
    private Status status;
    private LocalDateTime createdDateTime;
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
