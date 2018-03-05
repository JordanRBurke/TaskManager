package com.company;

import javafx.concurrent.Task;
import java.io.*;
import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {
    Calendar timeCompleted = Calendar.getInstance();

    Tasks task;
    Scanner input = new Scanner(System.in);
    List<Tasks> taskList = new ArrayList();

    BufferedWriter text;

    public void selectionMenu() throws FileNotFoundException, IOException {

        try {
            File newFile = new File("Testing.RTF");
            text = new BufferedWriter(new FileWriter("Testing.RTF",true));
            Scanner fileStalker = new Scanner(newFile);

            System.out.println((char) 27 + "[36m");
            System.out.println("Task Manager: \n" +
                    " 1. Create Task \n" +
                    " 2. List Tasks \n" +
                    " 3. View Uncompleted Tasks \n" +
                    " 4. Completed tasks \n" +
                    " 5. Mark task as complete \n" +
                    " 6. Remove a task \n" +
                    " 7. Edit a task \n" +
                    " 8. View task details \n" +
                    " 9. Exit task manager ");


            switch (input.nextInt()) {
                // Intersection that connects all the methods to the cases

                case 1:
                    createTask();
                    break;
                case 2:
                    listTask();
                    break;
                case 3:
                    viewUncompletedTasks();
                    break;
                case 4:
                    listOfTasksComplete();
                    break;
                case 5:
                    markCompletedTasks();
                    break;
                case 6:
                    removeTask();
                    break;
                case 7:
                    editTask();
                    break;
                case 8:
                    viewTaskDetails();
                    break;
                case 9:
                    // Closes the program
                    System.out.println(" Closing Program...... ");
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Please put a valid number ");
                    selectionMenu();
                    break;


            }

            text.write("");

            text.newLine();

            text.close();


        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("Invalid input ");
            selectionMenu();

        }
    }

    public void createTask() throws IOException{
//            taskList.clear();

        // Creating Task (Getting input from user)
        System.out.println(" Please create a title ");
        input.nextLine();
        String title = input.nextLine();
        System.out.println(" Please enter a due date for said task ");
        String dueDate = input.nextLine();
        System.out.println("Please add task details for your task");
        String taskDetails = input.nextLine();
        task = new Tasks(title, dueDate, taskDetails);
        task.setUncompleteTask(task.getTitle() + " (Incomplete) ");
        taskList.add(task);
        System.out.println("What would you like to do next? \n 1. Leave \n 2. Create another task ");
        if (input.nextInt() == 1) {
            selectionMenu();
        } else {
            createTask();
        }
    }

    public void listTask() throws IOException{


        // Lists tasks that user created in case 1
        int location = 1;
        System.out.println("These are your saved tasks: ");
//                        System.out.println(task.getTitle());
        for (int p = 0; p < taskList.size(); p++) {
            // Lists the objects the user created in case 1
            System.out.println(taskList.get(p).getTitle());
//
        }

        System.out.println("Would you like to go back to the menu? \n 1. Yes ");
        if (input.nextInt() == 1) {
            selectionMenu();
        }

    }

    public void viewUncompletedTasks() throws IOException{
        // Views uncompleted tasks the user has not checked off as completed in case 5
        int pushUp = 1;
        for (int l = 0; l < taskList.size(); l++) {
            System.out.println(pushUp + " " + taskList.get(l).getIncompleteTask());
            pushUp++;
        }
        System.out.println("Would you like to go back to the menu? \n 1. Yes");
        if (input.nextInt() == 1) {
            selectionMenu();
        }


    }

    public void listOfTasksComplete() throws IOException{

        // Completed tasks in which the user sets in case 5
        int pushUp = 1;
        for (int l = 0; l < taskList.size(); l++) {
            System.out.println(pushUp + " " + taskList.get(l).getCompletedTask());
            pushUp++;
        }
        System.out.println("This is a list of your tasks that you have completed \n" +
                " 1. " + task.getCompletedTask() + " \n" +
                " Would you like to go to the menu? \n" +
                " 1. Yes ");
        if (input.nextInt() == 1) {
            selectionMenu();
        }
    }

    public void markCompletedTasks() throws IOException{

        // Marking the task completes adds it to case 4 (Only completed tasks)
        System.out.println("Which task would you like to mark as complete?");
        int pushUp = 1;
        for (int l = 0; l < taskList.size(); l++) {
            System.out.println(pushUp + " " + taskList.get(l).getTitle());
            pushUp++;
        }
        int taskInfo = input.nextInt() - 1;
        timeCompleted.add(Calendar.DATE, 1);
        SimpleDateFormat dateCompleteFormat = new SimpleDateFormat("yyyy-MM-dd");
        task.setTitle(taskList.get(taskInfo).getTitle() + "Completed: " + dateCompleteFormat.format(timeCompleted.getTime()));
        task.setCompletedTask(taskList.get(taskInfo).getTitle());
        selectionMenu();

    }
        public void removeTask () throws IOException{

            // Removes task by removing the task from the arrayList
            int pushUp = 1;
            System.out.println(" Which one would you like to remove? ");
            for (int l = 0; l < taskList.size(); l++) {
                System.out.println(pushUp + " " + taskList.get(l).getTitle());
                pushUp++;
            }
            int taskInfo = input.nextInt() - 1;
            taskList.remove(taskList.get(taskInfo));
            System.out.println(" Would you like to go back to the menu? \n 1. Yes ");
            if (input.nextInt() == 1) {
                selectionMenu();
            }
        }




            public void editTask() throws IOException{

                // Edits task

                System.out.println(" Which one would you like to edit? ");
                int pushUp = 1;
                for (int l = 0 ; l < taskList.size() ; l++) {
                    System.out.println(pushUp + " " + taskList.get(l).getTitle());
                    pushUp++;
                }
                int taskInfo = input.nextInt() - 1;
                System.out.println(" Which one would you like to edit? \n" +
                        " 1. " + taskList.get(taskInfo).getTitle() + " \n" +
                        " 2. " + taskList.get(taskInfo).getDueDate() + " \n" +
                        " 3. " + taskList.get(taskInfo).getTaskDetails());
                if (input.nextInt() == 1) {
                    System.out.println(" What would your like the new title to be? ");
                    input.nextLine();
                    taskList.get(taskInfo).setTitle(input.nextLine());
                    editTask();
                } else if (input.nextInt() == 2) {
                    System.out.println(" What would you like your new DueDate to be? ");
                    input.nextLine();
                    taskList.get(taskInfo).setDueDate(input.nextLine());
                    editTask();
                } else if (input.nextInt() == 3) {
                    System.out.println(" What would you like your new Details to be?");
                    input.nextLine();
                    taskList.get(taskInfo).setTaskDetails(input.nextLine());
                    editTask();
                } else {
                    System.out.println("That was not a option");
                    selectionMenu();
                }

            }

            public void viewTaskDetails() {

                // Allows user to view details
                System.out.println(" Which task would you like to view?");
                int pushUp = 1;
                for (int l = 0 ; l < taskList.size() ; l++) {
                    System.out.println(pushUp + " " + taskList.get(l).getTitle());
                    pushUp++;
                }
                int taskInfo = input.nextInt() - 1;
                System.out.println(taskList.get(taskInfo).getTitle());
                System.out.println(taskList.get(taskInfo).getDueDate());
                System.out.println(taskList.get(taskInfo).getTaskDetails());

        }
                }










