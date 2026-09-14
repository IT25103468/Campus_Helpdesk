package com.campus.helpdesk.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    private String title;
    private String description;

    private String status;
    private String priority;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "assigned_staff_id")
    private Integer assignedStaffId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "faculty_id")
    private int facultyId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "staff_response", columnDefinition = "TEXT")
    private String staffResponse;

    @Column(name = "is_escalated")
    private boolean isEscalated;

    @Column(name = "admin_response", columnDefinition = "TEXT")
    private String adminResponse;

    // --- Database එකේ නැති, නමුත් UI එකට අවශ්‍ය අමතර දත්ත ---
    // @Transient යෙදීමෙන් මේවා Table එකේ Columns ලෙස සෑදෙන්නේ නැත.
    @Transient
    private String categoryName;

    @Transient
    private boolean canEscalate;

    @Transient
    private String studentUniversityId;

    public Ticket() {}

    // Getters & Setters (ඔයාගේ පරණ එකේ තිබුණු ටිකමයි කිසිම වෙනසක් නෑ)
    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public Integer getAssignedStaffId() { return assignedStaffId; }
    public void setAssignedStaffId(Integer assignedStaffId) { this.assignedStaffId = assignedStaffId; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getFacultyId() { return facultyId; }
    public void setFacultyId(int facultyId) { this.facultyId = facultyId; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    public String getStaffResponse() { return staffResponse; }
    public void setStaffResponse(String staffResponse) { this.staffResponse = staffResponse; }

    public boolean isEscalated() { return isEscalated; }
    public void setEscalated(boolean escalated) { isEscalated = escalated; }
    public boolean getIsEscalated() { return isEscalated; }

    public String getAdminResponse() { return adminResponse; }
    public void setAdminResponse(String adminResponse) { this.adminResponse = adminResponse; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public boolean isCanEscalate() { return canEscalate; }
    public void setCanEscalate(boolean canEscalate) { this.canEscalate = canEscalate; }

    public String getStudentUniversityId() { return studentUniversityId; }
    public void setStudentUniversityId(String studentUniversityId) { this.studentUniversityId = studentUniversityId; }
}
