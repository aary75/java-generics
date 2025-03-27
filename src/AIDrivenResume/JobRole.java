
package com.bridgelabz-AIDrivenResume;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Abstract base class for all job roles
abstract class JobRole {
    private String title;
    private List<String> requiredSkills;
    private List<String> preferredSkills;
    private int minExperienceYears;

    public JobRole(String title, List<String> requiredSkills, 
                 List<String> preferredSkills, int minExperienceYears) {
        this.title = title;
        this.requiredSkills = new ArrayList<>(requiredSkills);
        this.preferredSkills = new ArrayList<>(preferredSkills);
        this.minExperienceYears = minExperienceYears;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getRequiredSkills() {
        return new ArrayList<>(requiredSkills);
    }

    public List<String> getPreferredSkills() {
        return new ArrayList<>(preferredSkills);
    }

    public int getMinExperienceYears() {
        return minExperienceYears;
    }

    public abstract double calculateMatchScore(Resume<?> resume);

    @Override
    public String toString() {
        return title + " (min " + minExperienceYears + " years experience)";
    }
}
