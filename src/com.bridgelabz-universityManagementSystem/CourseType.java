package com.bridgelabz-universityManagementSystem;

import java.util.ArrayList;
import java.util.List;

// Abstract base class for all course types
abstract class CourseType {
    private String typeName;
    private int creditHours;

    public CourseType(String typeName, int creditHours) {
        this.typeName = typeName;
        this.creditHours = creditHours;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public abstract String getEvaluationMethod();

    @Override
    public String toString() {
        return typeName + " Course (" + creditHours + " credits)";
    }
}
