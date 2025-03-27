package com.bridgelabz-universityManagementSystem;
import java.util.*;


// Generic Course class
class Course<T extends CourseType> {
    private String courseCode;
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseCode, String courseName, String department, T courseType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public T getCourseType() {
        return courseType;
    }

    public void displayCourseDetails() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Department: " + department);
        System.out.println("Type: " + courseType);
        System.out.println("Evaluation: " + courseType.getEvaluationMethod());
        System.out.println("----------------------");
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName + " (" + department + ") - " + courseType;
    }
}
