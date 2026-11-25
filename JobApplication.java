package com.aditya.jobtracker;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
@Table(name = "job_applications")
public class JobApplication {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String company;
    @NotBlank private String role;
    @NotNull private LocalDate applicationDate;
    @Enumerated(EnumType.STRING) @NotNull private ApplicationStatus status;
    private String jobUrl;
    @Column(length = 1000) private String notes;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getCompany(){return company;} public void setCompany(String company){this.company=company;}
    public String getRole(){return role;} public void setRole(String role){this.role=role;}
    public LocalDate getApplicationDate(){return applicationDate;} public void setApplicationDate(LocalDate d){this.applicationDate=d;}
    public ApplicationStatus getStatus(){return status;} public void setStatus(ApplicationStatus s){this.status=s;}
    public String getJobUrl(){return jobUrl;} public void setJobUrl(String u){this.jobUrl=u;}
    public String getNotes(){return notes;} public void setNotes(String n){this.notes=n;}
}
