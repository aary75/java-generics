package com.bridgelabz-AIDrivenResume
import java.util.*;

// Concrete job role implementations
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer", 
             List.of("Java", "Data Structures", "Algorithms", "OOP"),
             List.of("Spring Framework", "Microservices", "Cloud Computing"),
             2);
    }

    @Override
    public double calculateMatchScore(Resume<?> resume) {
        double score = 0;
        
        // Check required skills
        for (String skill : getRequiredSkills()) {
            if (resume.getSkills().contains(skill)) {
                score += 2.0;
            }
        }
        
        // Check preferred skills
        for (String skill : getPreferredSkills()) {
            if (resume.getSkills().contains(skill)) {
                score += 1.0;
            }
        }
        
        // Experience factor
        if (resume.getExperienceYears() >= getMinExperienceYears()) {
            score += 3.0;
        } else if (resume.getExperienceYears() > 0) {
            score += 1.5;
        }
        
        // Education bonus
        if (resume.getEducation().contains("Computer Science")) {
            score += 1.5;
        }
        
        return score;
    }
}

