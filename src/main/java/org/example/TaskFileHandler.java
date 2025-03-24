package org.example;

import java.io.*;
import java.time.LocalDate;
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

    public static void loadTasks(List<Task> tasks){
        tasks.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(TASKS))){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 4){
                    String description = parts[0];
                    LocalDate dueDate = LocalDate.parse(parts[1]);
                    Priority priority = Priority.valueOf(parts[2]);
                    boolean isComplete = Boolean.parseBoolean(parts[3]);

                    Task task = new Task(description, dueDate, priority);
                    if(isComplete){
                        task.markAsCompleted();
                    }
                    tasks.add(task);
                }
            }
        }catch (IOException e){
            System.out.println("No saved tasks found.");
        }
    }
}
