package com.company;

import java.util.Scanner;
import java.io.Serializable;

public class Tasks implements Serializable {

    Scanner input = new Scanner(System.in);

    String title;
    String DueDate;
    String taskDetails;
    String dateCompleted;
    String completedTask;
    String IncompleteTask;
    String taskPullValue;

    public Tasks(String title, String dueDate, String taskDetails) {
        this.title = title;
        DueDate = dueDate;
        this.taskDetails = taskDetails;
    }

    public Tasks() {
    }

    public String getCompletedTask() {
        return completedTask;
    }

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

    public String getIncompleteTask() {
        return IncompleteTask;
    }

    public void setUncompleteTask(String IncompleteTask) {
        this.IncompleteTask = IncompleteTask;
    }

    public String getTaskPullValue() {
        return taskPullValue;
    }

    public void setTaskPullValue(String taskPullValue) {
        this.taskPullValue = taskPullValue;
    }
}


