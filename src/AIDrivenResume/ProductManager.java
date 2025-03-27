package com.bridgelabz-AIDrivenResume
import java.util.*;

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager", 
             List.of("Product Strategy", "Market Research", "Agile Methodologies"),
             List.of("User Experience", "Data Analysis", "Technical Background"),
             5);
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
                score += 1.5;
            }
        }
        
        // Experience factor (more important for PM roles)
        if (resume.getExperienceYears() >= getMinExperienceYears()) {
            score += 5.0;
        } else if (resume.getExperienceYears() > 2) {
            score += 2.0;
        }
        
        // Certification bonus
        if (resume.getCertifications().contains("PMP") || 
            resume.getCertifications().contains("Agile Certified")) {
            score += 2.0;
        }
        
        return score;
    }
}
