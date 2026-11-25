package com.aditya.jobtracker;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class JobApplicationController {
    private final JobApplicationService service;
    public JobApplicationController(JobApplicationService service){this.service=service;}
    @GetMapping public List<JobApplication> list(@RequestParam(required=false) String q,
       @RequestParam(required=false) ApplicationStatus status){
        if(status!=null)return service.byStatus(status);
        if(q!=null&&!q.isBlank())return service.search(q.trim());
        return service.all();
    }
    @GetMapping("/{id}") public JobApplication get(@PathVariable Long id){return service.get(id);}
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public JobApplication create(@Valid @RequestBody JobApplication item){return service.create(item);}
    @PutMapping("/{id}") public JobApplication update(@PathVariable Long id,@Valid @RequestBody JobApplication item){return service.update(id,item);}
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}
