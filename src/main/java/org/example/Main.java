package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private  static ArrayList<Task> tasks = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("ToDo List Application");
            System.out.println("1. ADD Task");
            System.out.println("2. View Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.println("Enter task description");
                    String description = scanner.nextLine();
                    System.out.println("Enter due date (yyyy-MM-dd):");
                    String dateInput = scanner.nextLine();
                    System.out.println("Enter Priority");
                    String inputPriority = scanner.nextLine();

                    LocalDate dueDate = null;
                    if(!dateInput.isEmpty()){
                        try{
                            dueDate = LocalDate.parse(dateInput);
                        }catch (Exception e){
                            System.out.println("Invalid date Format! Please enter date in yyyy-MM-dd format.");
                            break;
                        }
                    }else {
                        System.out.println("Due date cannot be empty!");
                    }

                    Priority priority = null;
                    if(!inputPriority.isEmpty()){
                        try{
                            priority = Priority.valueOf(inputPriority.toUpperCase());
                        }catch (Exception e){
                            System.out.println("Invalid Priority");
                        }

                        addTask(description, dueDate,priority);
                        break;
                    }else {
                        System.out.println("Please enter priority(low, medium, high)");
                    }

                case 2:
                    viewTasks();
                    break;
                case 3:
                    System.out.println("Enter task number to mark as complete");
                    int taskNumber = scanner.nextInt();
                    markTasksAsCompleted(taskNumber - 1);
                    break;
                case 4:
                    System.out.println("Enter task number to remove: ");
                    int taskToRemove = scanner.nextInt();
                    removeTask(taskToRemove - 1);
                    break;
                case 5:
                    running = false;
                    System.out.println("GoodBye!");
                    break;
                default:
                    System.out.println("Invalid option, Please try again");
            }


        }
    }

    private static void addTask(String description, LocalDate dueDate, Priority priority){
        if(dueDate != null){
            tasks.add(new Task(description, dueDate, priority));
            System.out.println("Task added!");
        }else {
            System.out.println("Please enter date");
        }

    }

    private static void  viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks available");
        }else{
            for(int i= 0; i< tasks.size(); i++){
                System.out.println((i+1) + "." + tasks.get(i));
            }
        }
    }

    private static  void markTasksAsCompleted(int index){
        if(index >= 0 && index< tasks.size()){
            tasks.get(index).markAsCompleted();
            System.out.println("Task marked as completed");
        }else{
            System.out.println("Invalid task number.");
        }
    }

    private static void  removeTask(int index){
        if(index >= 0 && index< tasks.size()){
            tasks.remove(index);
            System.out.println("Task removed!");
        }else {
            System.out.println("Invalid task number.");
        }
    }


}