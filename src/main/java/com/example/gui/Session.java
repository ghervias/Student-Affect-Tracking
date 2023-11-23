package com.example.gui;

import java.util.ArrayList;
import java.util.Objects;

public class Session {
    int durationMinutes;
    ArrayList<Task> tasks;
    int nextTaskIndex = 0;

    public Session(int durationMinutes, ArrayList<Task> tasks){
        this.durationMinutes = durationMinutes;
        this.tasks = tasks;
    }

    public static Session createSession(int duration, ArrayList<Task> tasks){
        if(duration <= 0){
            throw new IllegalArgumentException("Duration must be at least 1 second.");
        }
        if(tasks.size() == 0){
            throw new IllegalArgumentException("Must have at least one task.");
        }
        return new Session(duration, tasks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return durationMinutes == session.durationMinutes && Objects.equals(tasks, session.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(durationMinutes, tasks);
    }

    //ends the current Task (if there is one) and returns the next task (if there is one)
    public Task nextTask(){
        nextTaskIndex += 1;
        return tasks.get(nextTaskIndex - 1);
    }

    //returns the remaining time in the session
//    public int getRemainingTime(){}

    //starts the timer for the session, begins measurements
//    public void startSession(){
//        //start timer
//        //indicate first task
//    }
//
//    public void endSession(){}
//
//    //records an event that occurs, stores it together with a timestamp
//    public void addEvent(){}
}
