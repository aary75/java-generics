package com.bridgelabz-universityManagementSystem;
import java.util.*;


// Concrete course type implementations
class ExamCourse extends CourseType {
    private int examCount;

    public ExamCourse(int creditHours, int examCount) {
        super("Exam-Based", creditHours);
        this.examCount = examCount;
    }

    @Override
    public String getEvaluationMethod() {
        return examCount + " exams during semester";
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getEvaluationMethod();
    }
}
