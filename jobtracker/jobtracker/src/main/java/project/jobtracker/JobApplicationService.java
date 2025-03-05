package project.jobtracker;

//public class jobApplicationService {
//
//}

//import com.yourcompany.jobtracker.model.JobApplication;
//import com.yourcompany.jobtracker.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    public List<JobApplication> getAllApplications() {
        return jobApplicationRepository.findAll();
    }

    public JobApplication getApplicationById(Long id) {
        Optional<JobApplication> jobApplication = jobApplicationRepository.findById(id);
        return jobApplication.orElse(null);
    }

    public JobApplication createApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public JobApplication updateApplication(Long id, JobApplication jobApplication) {
        if (jobApplicationRepository.existsById(id)) {
            jobApplication.setId(id);
            return jobApplicationRepository.save(jobApplication);
        }
        return null;
    }

    public boolean deleteApplication(Long id) {
        if (jobApplicationRepository.existsById(id)) {
            jobApplicationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
