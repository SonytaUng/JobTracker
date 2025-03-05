package project.jobtracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobApplicationController {
	
	@Autowired
    private JobApplicationService jobApplicationService;

    // Get all job applications
    @GetMapping
    public List<JobApplication> getAllApplications() {
        return jobApplicationService.getAllApplications();
    }

    // Get a single job application by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getApplicationById(@PathVariable Long id) {
        JobApplication jobApplication = jobApplicationService.getApplicationById(id);
        if (jobApplication == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobApplication, HttpStatus.OK);
    }

    // Create a new job application
    @PostMapping
    public ResponseEntity<JobApplication> createApplication(@RequestBody JobApplication jobApplication) {
        JobApplication savedJobApplication = jobApplicationService.createApplication(jobApplication);
        return new ResponseEntity<>(savedJobApplication, HttpStatus.CREATED);
    }

    // Update an existing job application
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) {
        JobApplication updatedJobApplication = jobApplicationService.updateApplication(id, jobApplication);
        if (updatedJobApplication == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }

    // Delete a job application
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        boolean isDeleted = jobApplicationService.deleteApplication(id);
        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@GetMapping("/api/getall")
	public String getAll() {
		return "Get all the jobs list";
		
	}
	
	@GetMapping("/api/get/{$id}")
	public String getjobById() {
		return "Get a jobs by id";
		
	}

}
