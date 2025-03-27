package com.bridgelabz-AIDrivenResume
import java.util.*;

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist", 
             List.of("Python", "Machine Learning", "Statistics", "Data Analysis"),
             List.of("Deep Learning", "Big Data", "SQL", "Data Visualization"),
             3);
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
            score += 1.0;
        }
        
        // Education bonus
        if (resume.getEducation().contains("Data Science") || 
            resume.getEducation().contains("Statistics")) {
            score += 2.0;
        }
        
        return score;
    }
}
