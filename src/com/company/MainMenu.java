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


        switch (input.nextInt()) {

            case 1:

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

            case 3:

                System.out.println("Uncomplete tasks: \n " + taskList.get(0) + " (Incomplete) " + taskList.get(1) + " (Incomplete) ");



        }


    }


}










