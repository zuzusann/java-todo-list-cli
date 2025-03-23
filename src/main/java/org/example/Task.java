package org.example;

import java.time.LocalDate;



public class Task {

    private String description;
    private boolean isComplete;
    private LocalDate dueDate;
    private Priority priority;

    public Task(String description,LocalDate dueDate, Priority priority){
        this.description = description;
        this.isComplete = false;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getDescription(){
        return  description;
    }

    public boolean isComplete(){
        return  isComplete;
    }

    public LocalDate getDueDate(){
        return  dueDate;
    }

    public void markAsCompleted(){
        this.isComplete = true;
    }

    @Override
    public String toString(){
        return (isComplete ? "[Done]" : "[Not Done]") + description + " DueDate: " + dueDate + " Priority: " + priority;
    }
}
