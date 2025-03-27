package com.bridgelabz-AIDrivenSystem;
import java.util.*;


// Demo class
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Create job roles
        SoftwareEngineer seRole = new SoftwareEngineer();
        DataScientist dsRole = new DataScientist();
        ProductManager pmRole = new ProductManager();

        // Create resumes for different roles
        Resume<SoftwareEngineer> seResume = new Resume<>(
            "John Doe",
            List.of("Java", "Spring Framework", "Microservices", "OOP", "SQL"),
            "MS in Computer Science",
            5,
            List.of("AWS Certified"),
            seRole
        );

        Resume<DataScientist> dsResume = new Resume<>(
            "Jane Smith",
            List.of("Python", "Machine Learning", "Statistics", "Data Visualization"),
            "PhD in Data Science",
            4,
            List.of("TensorFlow Certification"),
            dsRole
        );

        Resume<ProductManager> pmResume = new Resume<>(
            "Alex Johnson",
            List.of("Product Strategy", "Agile Methodologies", "User Experience"),
            "MBA",
            6,
            List.of("PMP", "Agile Certified"),
            pmRole
        );

        // Another resume that might not match as well
        Resume<SoftwareEngineer> juniorSeResume = new Resume<>(
            "Bob Wilson",
            List.of("Java", "OOP"),
            "BS in Computer Engineering",
            1,
            List.of(),
            seRole
        );

        // Create screening system
        AIScreeningSystem screeningSystem = new AIScreeningSystem();

        // Screen individual resumes
        screeningSystem.screenResume(seResume);
        screeningSystem.screenResume(dsResume);
        screeningSystem.screenResume(pmResume);
        screeningSystem.screenResume(juniorSeResume);

        // Create a list of all resumes (using wildcard)
        List<Resume<? extends JobRole>> allResumes = List.of(
            seResume, dsResume, pmResume, juniorSeResume
        );

        // Screen all resumes together
        screeningSystem.screenAllResumes(allResumes);

        // Find top 2 candidates across all roles
        System.out.println("\n=== TOP 2 CANDIDATES ===");
        List<Resume<? extends JobRole>> topCandidates = 
            screeningSystem.findTopCandidates(allResumes, 2);
        for (Resume<? extends JobRole> resume : topCandidates) {
            System.out.println(resume.getCandidateName() + " (" + 
                              resume.getTargetRole().getTitle() + "): " +
                              resume.calculateMatchScore());
        }

        // Filter Software Engineer resumes with custom criteria
        List<Resume<SoftwareEngineer>> seResumes = List.of(seResume, juniorSeResume);
        List<Resume<SoftwareEngineer>> experiencedSEs = screeningSystem.filterResumes(
            seResumes, 
            r -> r.getExperienceYears() >= 3
        );
        
        System.out.println("\nExperienced Software Engineers:");
        experiencedSEs.forEach(r -> System.out.println(r.getCandidateName()));
    }
}
