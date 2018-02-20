package com.company;
import javafx.concurrent.Task;

import java.util.Scanner;
public class MainMenu {



    public void selectionMenu() {

        Scanner input = new Scanner(System.in);
        TaskArrayList task = new TaskArrayList();


        System.out.println("Task Manager: \n" +
                " 1. Create Task \n" +
                " 2. List Tasks \n" +
                " 3. View Uncompleted Tasks \n" +
                " 4. Completed tasks " +
                " 5. Mark task as complete \n" +
                " 6. Remove a task \n" +
                " 7. Edit a task \n" +
                " 8. View task details \n" +
                " 9. Exit task manager ");
        input.nextInt();
        task.arrayListOfTasks();
        switch (input.nextInt()) {

            case 1:

                System.out.println(" Please create a title ");
                input.nextLine();
                Task task = new Task() {










        }









    }









}
