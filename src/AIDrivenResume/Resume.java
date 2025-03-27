package com.bridgelabz-AIDrivenSystem;
import java.util.*;


// Generic Resume class
class Resume<T extends JobRole> {
    private String candidateName;
    private List<String> skills;
    private String education;
    private int experienceYears;
    private List<String> certifications;
    private T targetRole;

    public Resume(String candidateName, List<String> skills, String education,
                int experienceYears, List<String> certifications, T targetRole) {
        this.candidateName = candidateName;
        this.skills = new ArrayList<>(skills);
        this.education = education;
        this.experienceYears = experienceYears;
        this.certifications = new ArrayList<>(certifications);
        this.targetRole = targetRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    public String getEducation() {
        return education;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public List<String> getCertifications() {
        return new ArrayList<>(certifications);
    }

    public T getTargetRole() {
        return targetRole;
    }

    public double calculateMatchScore() {
        return targetRole.calculateMatchScore(this);
    }

    @Override
    public String toString() {
        return "Resume for " + candidateName + " targeting " + targetRole.getTitle() +
               "\nEducation: " + education +
               "\nExperience: " + experienceYears + " years" +
               "\nSkills: " + String.join(", ", skills) +
               "\nCertifications: " + String.join(", ", certifications);
    }
}
