package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TaskFileHandler {

    private static final String TASKS = "tasks.txt";

    public static  void saveTasks(List<Task> tasks){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(TASKS))){
            for(Task task: tasks){
                writer.write(task.getDescription() + "," + task.isComplete());
                writer.newLine();
            }
        }catch (IOException e){
            System.out.println("Error Saving Tasks.");
        }
    }
}
