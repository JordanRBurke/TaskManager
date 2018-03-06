package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileSerialize extends MainMenu{
    // Used to save it to the text file


    public void steralizeThis() {

        try {
            // Writing object to file
            System.out.println(" Select the task you would like to save ");

            int steralizeInput = input.nextInt() - 1;
            Tasks taskSaveProcess = new Tasks(taskList.get(steralizeInput).getTitle(),
                    taskList.get(steralizeInput).getDueDate(),
                    taskList.get(steralizeInput).getTaskDetails());

            FileOutputStream fileWrite = new FileOutputStream("Testing.RTF");
            ObjectOutputStream fileObject = new ObjectOutputStream(fileWrite);
            fileObject.writeObject(taskSaveProcess);
            fileObject.close();

            // Printing object to file
            FileInputStream fileRead = new FileInputStream("Testing.RTF");
            ObjectInputStream fileInput = new ObjectInputStream(fileRead);
            Tasks result = (Tasks) fileInput.readObject();
            fileInput.close();
            System.out.println(" Tasks have been saved! ");


        } catch (FileNotFoundException ime) {
            ime.printStackTrace();
        } catch (IOException ime) {
            ime.printStackTrace();
        } catch (ClassNotFoundException ime) {
            ime.printStackTrace();
        }


    }



}
