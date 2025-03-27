package com.bridgelabz-universityManagementSystem;
import java.util.*;


class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(int creditHours, String researchTopic) {
        super("Research-Based", creditHours);
        this.researchTopic = researchTopic;
    }

    @Override
    public String getEvaluationMethod() {
        return "Research paper on: " + researchTopic;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getEvaluationMethod();
    }
}
