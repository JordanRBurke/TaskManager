package com.company;

import javafx.concurrent.Task;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {
    Calendar timeCompleted = Calendar.getInstance();

    Tasks task;
    Scanner input = new Scanner(System.in);
    List<Tasks> taskList = new ArrayList();
    int pushUp = 1;
    public void selectionMenu() {

        try {
            System.out.println((char)27 + "[36m");
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

        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("Invalid input ");
            selectionMenu();

        }
    }

        public void createTask() {
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
            task.setUncompleteTask(task.getTitle());
            taskList.add(task);
            System.out.println("What would you like to do next? \n 1. Leave \n 2. Create another task ");
            if (input.nextInt() == 1) {
                selectionMenu();
            } else {
                  createTask();
            }
        }

        public void listTask() {


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

            public void viewUncompletedTasks() {
                // Views uncompleted tasks the user has not checked off as completed in case 5
                for (int l = 0 ; l < taskList.size() ; l++) {
                    System.out.println(pushUp + " " + taskList.get(l).getIncompleteTask());
                    pushUp++;
                }
                selectionMenu();


            }

            public void listOfTasksComplete() {

                // Completed tasks in which the user sets in case 5
                System.out.println("This is a list of your tasks that you have completed \n" +
                        " 1. " + task.getCompletedTask() + " \n" +
                        " Would you like to go to the menu? \n" +
                        " 1. Yes ");
                if (input.nextInt() == 1) {
                    selectionMenu();
                }
            }

            public void markCompletedTasks() {

                // Marking the task completes adds it to case 4 (Only completed tasks)
                System.out.println("Which task would you like to mark as complete?");

                for (int l = 0 ; l < taskList.size() ; l++) {
                    System.out.println(pushUp + " " + taskList.get(l).getTitle());
                    pushUp++;
                }

                int inputCase5 = input.nextInt();
                // Mark 1 as completed
                if (inputCase5 == 1) {
                    // Adds time to completed task
                    timeCompleted.add(Calendar.DATE, 1);
                    SimpleDateFormat dateCompleteFormat = new SimpleDateFormat("yyyy-MM-dd");
                    task.setTitle(taskList.get(0).getTitle() + " Completed: " + dateCompleteFormat.format(timeCompleted.getTime()));
                    task.setCompletedTask(taskList.get(0).getTitle());
                    System.out.println(" Would you like to go back to the main menu? \n" +
                            " 3. Yes");
                    if (input.nextInt() == 3) {
                        System.out.println(" Task has been marked completed! ");
                        selectionMenu();
                    }

                    //mark 2 as completed
                } else if (inputCase5 == 2) {
                    // adds time to completed task
                    timeCompleted.add(Calendar.DATE, 1);
                    SimpleDateFormat dateCompleteFormat = new SimpleDateFormat("yyyy-MM-dd");
                    task.setTitle(taskList.get(1).getTitle() + " Completed: " + dateCompleteFormat.format(timeCompleted.getTime()));
                    task.setCompletedTask(taskList.get(1).getTitle());
                    System.out.println(" Would you like to go back to the main menu? \n" +
                            " 3. Yes");
                    if (input.nextInt() == 3) {
                        System.out.println(" Task has been marked completed! ");
                        selectionMenu();
                    }
                }




            }

            public void removeTask() {

                // Removes task by removing the task from the arrayList

                System.out.println(" Which one would you like to remove? ");
                for (int l = 0 ; l < taskList.size() ; l++) {
                    System.out.println(pushUp + " " + taskList.get(l).getTitle());
                    pushUp++;
                }
                if (input.nextInt() == 1) {
                    taskList.remove(0);
                } else if (input.nextInt() == 2) {
                    taskList.remove(1);
                }
                System.out.println(" Would you like to go back to the menu? \n 1. Yes ");
                if (input.nextInt() == 1) {
                    selectionMenu();
                }


            }

            public void editTask() {

                // Edits task

                System.out.println(" Which one would you like to edit? ");
                for (int l = 0 ; l < taskList.size() ; l++) {
                    System.out.println(pushUp + " " + taskList.get(l).getTitle());
                    pushUp++;
                }
                if (input.nextInt() == 1) {
                    System.out.println(" 1. " + taskList.get(0).getTitle() + " \n" +
                            " 2. " + taskList.get(0).getDueDate() + " \n" +
                            " 3. " + taskList.get(0).getTaskDetails());
                    System.out.println(" Which sub option would you like to edit? ");
                    int inputForDetails = input.nextInt();
                    if (inputForDetails == 1) {
                        editTaskExtendedTitle();
                    } else if (inputForDetails == 2) {
                        editTaskExtendedDueDate();
                    } else if (inputForDetails == 3) {
                        editTaskExtendedTaskDetails();
                    }
                }

            }

            public void editTaskExtendedTitle() {

                // Extension from the edit task for titles only
                System.out.println(" What would you like your new title to be? ");
                input.nextLine();
                taskList.get(0).setTitle(input.nextLine());
                System.out.println(" Would you like to change your \n 1. DueDate \n 2. TaskDetails \n 3. menu");
                int inputTaskTitle = input.nextInt();
                if (inputTaskTitle == 1) {
                    editTaskExtendedDueDate();
                } else if (inputTaskTitle == 2) {
                    editTaskExtendedTaskDetails();
                } else {
                    selectionMenu();
                }


            }

            public void editTaskExtendedDueDate() {

                // extension of edit task for DueDate
                System.out.println(" What would you like your new DueDate to be? ");
                input.nextLine();
                taskList.get(0).setTitle(input.nextLine());
                System.out.println(" What would you like to do next? \n 1. Edit Title \n 2. Edit TaskDetails \n 3. menu ");
                int inputEditDueDate = input.nextInt();
                if (inputEditDueDate == 1) {
                    editTaskExtendedTitle();
                } else if (inputEditDueDate == 2) {
                    editTaskExtendedTaskDetails();
                } else {
                    selectionMenu();
                }



            }

            public void editTaskExtendedTaskDetails() {

                // edit task extension for task details
                System.out.println(" What would you like your new details to be called? ");
                input.nextLine();
                taskList.get(0).setTitle(input.nextLine());
                System.out.println(" Which would you like to do now? \n 1. Edit Title \n 2. Edit Task DueDate \n 3. menu");
                int inputTaskDetails = input.nextInt();
                if (inputTaskDetails == 1) {
                    editTaskExtendedTitle();
                } else if (inputTaskDetails == 2) {
                    editTaskExtendedDueDate();
                } else {
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
            }
        }
                }










