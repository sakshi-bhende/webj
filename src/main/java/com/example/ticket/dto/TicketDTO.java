
package com.example.ticket.dto;

import java.time.LocalDateTime;

public class TicketDTO {
    private Long id;
    private String requesterPhoneNumber;
    private String category;
    private String issueDetails;
    private String resolutionDetails;
    private String status;
    private LocalDateTime createDateTime;
    private LocalDateTime resolutionDateTime;

    // Getters and Setters
}
