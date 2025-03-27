package com.bridgelabz-universityManagementSystem;
import java.util.*;

// Department class to manage courses
class Department {
    private String name;
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Method using wildcard to add any type of course
    public void addCourse(Course<? extends CourseType> course) {
        if (!course.getDepartment().equals(this.name)) {
            System.out.println("Warning: Course " + course.getCourseCode() + 
                             " belongs to " + course.getDepartment() + 
                             ", not " + this.name);
        }
        courses.add(course);
        System.out.println("Added course: " + course.getCourseCode());
    }

    // Wildcard method to display all courses
    public void displayAllCourses() {
        System.out.println("\n=== " + name + " Department Courses ===");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course<? extends CourseType> course : courses) {
                course.displayCourseDetails();
            }
        }
    }

    // Method to get courses by specific type
    public <T extends CourseType> List<Course<T>> getCoursesByType(Class<T> typeClass) {
        List<Course<T>> result = new ArrayList<>();
        for (Course<? extends CourseType> course : courses) {
            if (typeClass.isInstance(course.getCourseType())) {
                result.add((Course<T>) course);
            }
        }
        return result;
    }

    // Method to calculate total credit hours
    public int getTotalCreditHours() {
        return courses.stream()
                .mapToInt(c -> c.getCourseType().getCreditHours())
                .sum();
    }
}
