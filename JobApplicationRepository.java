package com.aditya.jobtracker;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatusOrderByApplicationDateDesc(ApplicationStatus status);
    List<JobApplication> findByCompanyContainingIgnoreCaseOrRoleContainingIgnoreCaseOrderByApplicationDateDesc(String company, String role);
}
