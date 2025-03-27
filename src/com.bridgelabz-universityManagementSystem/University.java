package com.bridgelabz-universityManagementSystem;
import java.util.*;


// University class to manage departments
class University {
    private List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println("Added department: " + department.getName());
    }

    public void displayAllDepartments() {
        System.out.println("\n=== University Departments ===");
        departments.forEach(dept -> {
            System.out.println(dept.getName() + " - " + 
                    dept.getCourses().size() + " courses, " + 
                    dept.getTotalCreditHours() + " total credits");
        });
    }

    // Method to find courses across all departments by type
    public <T extends CourseType> List<Course<T>> findAllCoursesByType(Class<T> typeClass) {
        List<Course<T>> result = new ArrayList<>();
        for (Department dept : departments) {
            result.addAll(dept.getCoursesByType(typeClass));
        }
        return result;
    }
}
