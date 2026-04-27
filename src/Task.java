/**
 * File: Task.java
 * Course: CSCI 1301 Programming Principles I
 * Author: Jayson Williams
 * Created on: 04/27/2026
 * Description: Represents a single task with a title, description, category,
 * priority, due date, and completion status.
 */

public class Task {
    private String title;
    private String description;
    private String category;
    private String priority;
    private String dueDate;
    private boolean completed;

    public Task(String title, String description, String category,
                String priority, String dueDate, boolean completed) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void markComplete() {
        completed = true;
    }

    public String toFileString() {
        return title + "|" + description + "|" + category + "|"
                + priority + "|" + dueDate + "|" + completed;
    }

    @Override
    public String toString() {
        String status;

        if (completed) {
            status = "Completed";
        }
        else {
            status = "Not Completed";
        }

        return "Title: " + title
                + "\nDescription: " + description
                + "\nCategory: " + category
                + "\nPriority: " + priority
                + "\nDue Date: " + dueDate
                + "\nStatus: " + status;
    }
}