package com.company;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    Tasks task1 = new Tasks();
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
            try {
                switch (input.nextInt()) {

                    case 1:
                        taskList.clear();
                        // Creating Task (Getting input from user)
                        System.out.println(" Please create a title ");
                        input.nextLine();
                        task.setTitle(input.nextLine());
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
                            task1.setTitle(input.nextLine());
                            System.out.println(" Please enter a due date for said task ");
                            task1.setDueDate(input.nextLine());
                            System.out.println("Please add task details for your task");
                            task1.setTaskDetails(input.nextLine());
                            taskList.add(task1);
                            selectionMenu();

                        }


                        selectionMenu();
                        break;

                    case 2:

                        // Lists tasks that user created in case 1
                        int location = 1;
                        System.out.println("These are your saved tasks: ");
//                        System.out.println(task.getTitle());
                        for (int p = 0; p < taskList.size(); p++)
                            // Lists the objects the user created in case 1
//
                            System.out.println(taskList.get(p).getTitle());
                        System.out.println("Would you like to go back to the menu? \n 1. Yes ");
                        if (input.nextInt() == 1) {
                            selectionMenu();
                        }
                        break;

                    case 3:
                        // Views uncompleted tasks the user has not checked off as completed in case 5
                        System.out.println("Uncomplete tasks: \n " + taskList.get(0).getTitle() + " (Uncompleted) " + taskList.get(1).getTitle() + " (Uncompleted) ");

                        break;

                    case 4:
                        // Completed tasks in which the user sets in case 5
                        System.out.println("This is a list of your tasks that you have completed \n" +
                                " 1. " + task.getCompletedTask() + " \n" +
                                " Would you like to go to the menu? \n" +
                                " 1. Yes ");
                        if (input.nextInt() == 1) {
                            selectionMenu();
                        }


                        break;

                    case 5:
                        // Marking the task completes adds it to case 4 (Only completed tasks)
                        System.out.println("Which task would you like to mark as complete? \n" +
                                " 1. " + taskList.get(0).getTitle() + " \n" +
                                " 2. " + taskList.get(1).getTitle());

                        int inputCase5 = input.nextInt();
                        // Mark 1 as completed
                        if (inputCase5 == 1) {
                            task.setTitle(taskList.get(0).getTitle() + " (Completed) ");
                            task.setCompletedTask(taskList.get(0).getTitle());
                            System.out.println(" Would you like to go back to the main menu? \n" +
                                    " 3. Yes");
                            if (input.nextInt() == 3) {
                                System.out.println(" Task has been marked completed! ");
                                selectionMenu();
                            }

                        //mark 2 as completed
                        } else if (inputCase5 == 2) {
                            task1.setTitle(taskList.get(1).getTitle() + " (Completed) ");
                            task.setCompletedTask(taskList.get(1).getTitle());
                            System.out.println(" Would you like to go back to the main menu? \n" +
                                    " 3. Yes");
                            if (input.nextInt() == 3) {
                                System.out.println(" Task has been marked completed! ");
                                selectionMenu();
                            }
                        }

                        break;

                    case 6:
                        // Removes task
                        System.out.println("Which tasks would you like to remove? \n" +
                                " 1. " + taskList.get(0).getTitle() + " \n" +
                                " 2. " + taskList.get(1).getTitle());
                        if (input.nextInt() == 1) {
                            taskList.get(0).setTitle(" ");
                            taskList.get(0).setDueDate(" ");
                            taskList.get(0).setTaskDetails(" ");
//                    taskList.remove(0);
                            System.out.println("Would you like to exit? \n 1. Yes ");
                            if (input.nextInt() == 1) {
                                selectionMenu();
                            }

                        // Removes task 2
                        } else if (input.nextInt() == 2) {
                            taskList.get(1).setTitle(" ");
                            taskList.get(1).setDueDate(" ");
                            taskList.get(1).setTaskDetails(" ");
                            System.out.println(" Would you like to go back to the main menu? \n 1. Yes");
                            if (input.nextInt() == 1) {
                                selectionMenu();
                            }
                        }
                        break;

                    case 7:
                        // Edits task
                        System.out.println("Which task would you like to edit? \n" +
                                " 1. " + taskList.get(0).getTitle() + " \n" +
                                " 2. " + taskList.get(1).getTitle());
                        if (input.nextInt() == 1) {
                            // Asks what you want to edit about the title chosen
                            System.out.println(" Which segment would you like to edit? \n" +
                                    " 1. Title \n" +
                                    " 2. DueDate \n" +
                                    " 3. Description");
                            int userEdit = input.nextInt();
                            if (userEdit == 1) {
                                // Allows you to edit the title
                                System.out.println(" What would you like your new title to be? ");
                                input.nextLine();
                                taskList.get(0).setTitle(input.nextLine());
                                System.out.println(" Would you like to change the DueDate (3) ? Or go to the menu (6)");
                                if (input.nextInt() == 6) {
                                    // Takes you back to the main menu
                                    selectionMenu();
                                }
                            } else if (userEdit == 2) {
                                // Edits the dueDate that you set in case 1 of the title you selected
                                System.out.println(" What would you like your new DueDate to be? ");
                                input.nextLine();
                                taskList.get(0).setDueDate(input.nextLine());
                                System.out.println(" Would you like to change the Description? (3) ? Or go to the menu (6)");
                                if (userEdit == 3) {
                                    System.out.println(" What would you like your new description to say? ");
                                    input.nextLine();
                                    taskList.get(0).setTaskDetails(input.nextLine());
                                    selectionMenu();
                                } else if (userEdit == 6) {
                                    // Takes user back to the main menu
                                    selectionMenu();
                                }

                            } else if (userEdit == 3) {
                                System.out.println(" What would you like your new description to be? ");
                                input.nextLine();
                                taskList.get(0).setTaskDetails(input.nextLine());
                                System.out.println(" Your description has been saved! ");
                                selectionMenu();
                            }
                            System.out.println(" Would you like to go back to the menu? \n 1. Yes ");
                            if (input.nextInt() == 1) {
                                selectionMenu();
                            }
                        }
                        break;
                    case 8:
                        // Allows user to view details
                        System.out.println(" Which task would you like to view? \n" +
                                " 1. " + taskList.get(0).getTitle() + " \n" +
                                " 2. " + taskList.get(1).getTitle());
                        if (input.nextInt() == 1) {
                            // Views what user put down for case 1, but other details. Not just a title
                            System.out.println(" Here are your details: \n" +
                                    "" + " Description - " + taskList.get(0).getTaskDetails() + " \n" +
                                    " DueDate - " + taskList.get(0).getDueDate());
                            System.out.println(" Would you like to go back to the menu? \n 1. Yes");
                            if (input.nextInt() == 1) {
                                // Takes user back to the main menu
                                selectionMenu();
                            }
                            if (input.nextInt() == 2) {
                                // Allows user to view the second task they made
                                System.out.println(" Here are your details: \n" +
                                        "" + " Description - " + taskList.get(1).getTaskDetails() + " \n" +
                                        " DueDate - " + taskList.get(1).getDueDate());
                                System.out.println(" Would you like to go back to the menu? \n 1. Yes");
                                if (input.nextInt() == 1) {
                                    // Takes user back to the main menu
                                    selectionMenu();


                                }


                            }
                            break;



                        }
                    case 9:
                        // Closes the program
                        System.out.println(" Closing Program...... ");
                        System.exit(0);
                        break;

                }
            } catch (IndexOutOfBoundsException ime) {
                // Catches issues due to user input
                System.out.println("Error, please make sure you put a valid number");
                selectionMenu();



            }
        } catch (IndexOutOfBoundsException ime) {
            // Catches issues due to user input
            System.out.println("Error, please make sure you put a valid number");
            selectionMenu();
        }
    }
}









