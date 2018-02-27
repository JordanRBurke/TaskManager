package com.company;

import java.util.Scanner;

public class Tasks {

    Scanner input = new Scanner(System.in);

    String title;
    String DueDate;
    String taskDetails;
    String dateCompleted;
    String completedTask;

    public String getCompletedTask() {
        return completedTask;
    }


    /** You need a constructor for tasks. Tasks should have a title, duedate, detail, isCompleted, date completed, etc.
     * And when you create a Task elsewhere in your app, you'd access these values via getters. */

    public void setCompletedTask(String completedTask) {
        this.completedTask = completedTask;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}


