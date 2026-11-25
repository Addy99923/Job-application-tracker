package com.aditya.jobtracker;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JobApplicationService {
    private final JobApplicationRepository repository;
    public JobApplicationService(JobApplicationRepository repository){this.repository=repository;}
    public List<JobApplication> all(){return repository.findAll();}
    public JobApplication get(Long id){return repository.findById(id).orElseThrow(()->new IllegalArgumentException("Application not found: "+id));}
    public JobApplication create(JobApplication item){item.setId(null); return repository.save(item);}
    public JobApplication update(Long id, JobApplication input){
        JobApplication old=get(id); old.setCompany(input.getCompany()); old.setRole(input.getRole());
        old.setApplicationDate(input.getApplicationDate()); old.setStatus(input.getStatus());
        old.setJobUrl(input.getJobUrl()); old.setNotes(input.getNotes()); return repository.save(old);
    }
    public void delete(Long id){repository.delete(get(id));}
    public List<JobApplication> search(String q){return repository.findByCompanyContainingIgnoreCaseOrRoleContainingIgnoreCaseOrderByApplicationDateDesc(q,q);}
    public List<JobApplication> byStatus(ApplicationStatus s){return repository.findByStatusOrderByApplicationDateDesc(s);}
}
