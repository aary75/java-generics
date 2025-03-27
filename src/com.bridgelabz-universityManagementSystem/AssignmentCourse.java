package com.bridgelabz-universityManagementSystem;
import java.util.*;


class AssignmentCourse extends CourseType {
    private int assignmentCount;

    public AssignmentCourse(int creditHours, int assignmentCount) {
        super("Assignment-Based", creditHours);
        this.assignmentCount = assignmentCount;
    }

    @Override
    public String getEvaluationMethod() {
        return assignmentCount + " assignments with deadlines";
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getEvaluationMethod();
    }
}
