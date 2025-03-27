package com.bridgelabz-AIDrivenResume
import java.util.*;


// AI Screening System
class AIScreeningSystem {
    // Generic method to screen a single resume
    public <T extends JobRole> void screenResume(Resume<T> resume) {
        double score = resume.calculateMatchScore();
        System.out.println("\nScreening resume for: " + resume.getCandidateName());
        System.out.println("Target role: " + resume.getTargetRole().getTitle());
        System.out.println("Match score: " + score);
        
        if (score >= 8.0) {
            System.out.println("Status: STRONG MATCH - Immediate interview recommended");
        } else if (score >= 5.0) {
            System.out.println("Status: POTENTIAL MATCH - Further review needed");
        } else {
            System.out.println("Status: WEAK MATCH - Not recommended");
        }
    }

    // Wildcard method to screen multiple resumes for various roles
    public void screenAllResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("\n=== SCREENING ALL RESUMES ===");
        for (Resume<? extends JobRole> resume : resumes) {
            screenResume(resume);
        }
    }

    // Generic method to filter resumes by custom criteria
    public <T extends JobRole> List<Resume<T>> filterResumes(
            List<Resume<T>> resumes, Predicate<Resume<T>> criteria) {
        List<Resume<T>> result = new ArrayList<>();
        for (Resume<T> resume : resumes) {
            if (criteria.test(resume)) {
                result.add(resume);
            }
        }
        return result;
    }

    // Method to find top candidates across all roles
    public List<Resume<? extends JobRole>> findTopCandidates(
            List<? extends Resume<? extends JobRole>> resumes, int count) {
        List<Resume<? extends JobRole>> sorted = new ArrayList<>(resumes);
        sorted.sort((r1, r2) -> 
            Double.compare(r2.calculateMatchScore(), r1.calculateMatchScore()));
        return sorted.subList(0, Math.min(count, sorted.size()));
    }
}
