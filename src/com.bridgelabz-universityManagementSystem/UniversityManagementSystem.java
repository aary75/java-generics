package com.bridgelabz-universityManagementSystem;
import java.util.*x;

// Demo class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create course types
        ExamCourse examCourse = new ExamCourse(4, 2);
        AssignmentCourse assignmentCourse = new AssignmentCourse(3, 5);
        ResearchCourse researchCourse = new ResearchCourse(6, "Machine Learning Applications");

        // Create courses
        Course<ExamCourse> math101 = new Course<>("MATH101", "Calculus I", "Mathematics", examCourse);
        Course<AssignmentCourse> cs101 = new Course<>("CS101", "Introduction to Programming", "Computer Science", assignmentCourse);
        Course<ResearchCourse> cs499 = new Course<>("CS499", "Senior Thesis", "Computer Science", researchCourse);
        Course<ExamCourse> phys201 = new Course<>("PHYS201", "Quantum Physics", "Physics", new ExamCourse(5, 3));

        // Create departments
        Department mathDept = new Department("Mathematics");
        Department csDept = new Department("Computer Science");
        Department physicsDept = new Department("Physics");

        // Add courses to departments
        mathDept.addCourse(math101);
        csDept.addCourse(cs101);
        csDept.addCourse(cs499);
        physicsDept.addCourse(phys201);

        // Try adding a course to wrong department (will show warning)
        physicsDept.addCourse(math101);

        // Display department courses
        mathDept.displayAllCourses();
        csDept.displayAllCourses();
        physicsDept.displayAllCourses();

        // Create university and add departments
        University university = new University();
        university.addDepartment(mathDept);
        university.addDepartment(csDept);
        university.addDepartment(physicsDept);

        // Display all departments
        university.displayAllDepartments();

        // Find all exam-based courses across university
        List<Course<ExamCourse>> examCourses = university.findAllCoursesByType(ExamCourse.class);
        System.out.println("\nAll Exam-Based Courses:");
        examCourses.forEach(System.out::println);

        // Find all research-based courses in Computer Science
        List<Course<ResearchCourse>> researchCourses = csDept.getCoursesByType(ResearchCourse.class);
        System.out.println("\nResearch Courses in CS Department:");
        researchCourses.forEach(System.out::println);
    }
}
