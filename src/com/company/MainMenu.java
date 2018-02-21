package com.company;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    Tasks task = new Tasks();
    Scanner input = new Scanner(System.in);
    List<Tasks> taskList = new ArrayList();


    public void selectionMenu() {


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

        try {
            switch (input.nextInt()) {

                case 1:

                // Creating Task (Getting input from user)
                System.out.println(" Please create a title ");
                input.nextLine();
                task.setTitle(input.nextLine() + " (Uncomplete) ");
                System.out.println(" Please enter a due date for said task ");
                task.setDueDate(input.nextLine());
                System.out.println("Please add task details for your task");
                task.setTaskDetails(input.nextLine());
                taskList.add(task);
                System.out.println("What would you like to do next? \n 1. Leave \n 2. Create another task ");
                if (input.nextInt() == 1) {
                    selectionMenu();
                } else {

                    System.out.println(" Please create a title ");
                    input.nextLine();
                    task.setTitle(input.nextLine());
                    System.out.println(" Please enter a due date for said task ");
                    task.setDueDate(input.nextLine());
                    System.out.println("Please add task details for your task");
                    task.setTaskDetails(input.nextLine());
                    taskList.add(task);
                    selectionMenu();

                }


                selectionMenu();
                break;

                case 2:

                // Lists Task
                    System.out.println("These are your saved tasks: ");
                    System.out.println(task.getTitle());
                    System.out.println("Would you like to go back to the menu? \n 1. Yes ");
                    if (input.nextInt() == 1) {
                        selectionMenu();
                    }
                    break;

                case 3:

                    System.out.println("Uncomplete tasks: \n " + taskList.get(0).getTitle() + " (Uncompleted) " + taskList.get(1).getTitle() + " (Uncompleted) ");

                    break;

                case 4:
                    System.out.println("This is a list of your tasks that you have completed");

                    break;

                case 5:
                    System.out.println("Which task would you like to mark as complete? \n 1. " + taskList.get(0).getTitle());

                    if (input.nextInt() == 1) {
                    task.setTitle(taskList.get(0).getTitle() + " (Completed) ");
                    }
                    System.out.println("Would you like to go back to the menu? \n 1. Yes");
                    if (input.nextInt() == 1) {

                    }
                    break;

                case 6:
                    // Removes task
                    System.out.println("Which tasks would you like to remove? \n 1. " + taskList.get(0).getTitle());
                    if (input.nextInt() == 1) {
//                    taskList.remove(0);
                    System.out.println("Would you like to exit? \n 1. Yes ");
                    if (input.nextInt() == 1) {
                        selectionMenu();
                    }


                    }
                    break;

                case 7:
                    // Edits task
                    System.out.println("Which task would you like to edit? \n 1. " + taskList.get(0).getTitle());
                    if (input.nextInt() == 1) {
                        task.setTitle(" ");
                        System.out.println(" Task has been removed! Would you like to go back to the menu? \n 1. Yes ");
                        if (input.nextInt() == 1) {
                            selectionMenu();
                        }
                    }
                    break;
                case 8:
                    // Allows user to view details
                    System.out.println(" Which task would you like to view? \n 1. " + taskList.get(0).getTitle());
                    if (input.nextInt() == 1) {
                        System.out.println(" Here are your details: \n" +
                                "" + " Description - " + taskList.get(0).getTaskDetails() + " \n" +
                            " DueDate - " + taskList.get(0).getDueDate());
                        System.out.println(" Would you like to go back to the menu? \n 1. Yes");
                    if (input.nextInt() == 1) {
                        selectionMenu();
                    }
                }
                    break;

            case 9:
                // Closes the program
                System.out.println(" Closing Program...... ");
                System.exit(0);
                break;


        }

        } catch (IndexOutOfBoundsException ime) {
            System.out.println("Error, please make sure you put a valid number");
            selectionMenu();
        }


    }


}










