package tasks;

import java.util.ArrayList;
import java.util.Objects;
import javafx.scene.text.Text;

public class Session {
    int durationMinutes;
    ArrayList<Task> tasks;
    int nextTaskIndex = 0;
    Timer timer;

    public Session(int durationMinutes, ArrayList<Task> tasks){
        this.durationMinutes = durationMinutes;
        this.tasks = tasks;

        int[] array = {0};
        timer = new Timer(array, durationMinutes * 60);
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

    public int getTaskNumber(){
        return nextTaskIndex;
    }

    public void linkTimerText(Text timerText){
        timer.setTimerText(timerText);
        System.out.println("linking timer text..");
    }

    //returns the remaining time in the session
//    public int getRemainingTime(){}

    //starts the timer for the session, begins measurements
    public void startSession(){
        //start timer
        timer.startTimer();
    }
//
//    public void endSession(){}
//
//    //records an event that occurs, stores it together with a timestamp
//    public void addEvent(){}
}
