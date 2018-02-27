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


    /** Look up Rule of 3. Under normal circumstances, a method shouldn't be more than 30 lines long. This one is over 250 lines long. Split
     * this functionality up into multiple methods.  */

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

                /** To avoid unnecessary, stacking try/catch's, I recommend making your numerical values strings.
                 * '1', '2', etc., because then you won't need any try/catch's. You'll be able to make anything a String without a crash,
                 * '3', 'a', '!', you'll just have to set a default, 'if they don't enter any of these numerical strings, tell them to enter
                 * a valid command', then use recursion to make it prompt the user again. */
                switch (input.nextInt()) {

                    case 1:
                        taskList.clear();
                        // Creating Task (Getting input from user)
                        System.out.println(" Please create a title ");
                        input.nextLine();


                        /** Rather than making a member variable task (that's unnecessarily created every time the user creates a menu), it makes
                         * more sense to make the object here. Task task = new Task(), then use methods that will populate the values. So,
                         * you'll have a method called getTaskTitle() that has a Scanner in it and returns a String, based on what they enter for the title. Etc.
                         * So you'd be all, Task task - new Task(getTaskTitle(), getTaskDetails(), getTaskDueDate()); and that'd make your task object and make
                         * it very obvious what the code does. */
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
                        /** Change uncomplete to incomplete */
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
                                /** Not an efficient way to do this, as it limits the user's ability drastically. look at the arraylist workshop.
                                 * it should create a for loop based on each task in the array, no matter how many there are, and when they enter a number
                                 * to remove a task, you'll know to subtract 1 from it (since java starts at index 0), and to remove that particular task from
                                 * your arraylist. */

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

                        /** Not an efficient way to do this, as it limits the user's ability drastically. look at the arraylist workshop.
                         * it should create a for loop based on each task in the array, no matter how many there are, and when they enter a number
                         * to edit a task, you'll know to subtract 1 from it (since java starts at index 0), and to edit that particular task from
                         * your arraylist. */

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

                                /** Not an efficient way to do this, as it limits the user's ability drastically. look at the arraylist workshop.
                                 * it should create a for loop based on each task in the array, no matter how many there are, and when they enter a number
                                 * to view a task, you'll know to subtract 1 from it (since java starts at index 0), and to view that particular task from
                                 * your arraylist. */

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









