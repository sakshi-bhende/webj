
package com.example.ticket.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String requesterPhoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String issueDetails;

    private String resolutionDetails;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private LocalDateTime createDateTime;

    private LocalDateTime resolutionDateTime;

    public enum Category {
        SIM, CALLING, BROADBAND
    }

    public enum Status {
        OPEN, IN_PROGRESS, RESOLVED
    }

    // Getters and Setters
}
