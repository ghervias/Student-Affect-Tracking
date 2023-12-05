package tasks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

import data.Blackboard;
import javafx.scene.text.Text;

public class Session {
    int durationMinutes;
    ArrayList<Task> tasks;
    int nextTaskIndex = 0;
    Timer timer;
    int taskSwitchTime;
    BufferedWriter writer;
    String studentName;
    TreeMap<Integer, String> affectData = new TreeMap<>();
    TreeMap<Integer, String> padData = new TreeMap<>();

    private ArrayList<Integer> attemptTimes = new ArrayList<>(5);
    private ArrayList<String> answerAttempts = new ArrayList<>(5);

    public Session(int durationMinutes, ArrayList<Task> tasks, String studentName){
        this.durationMinutes = durationMinutes;
        this.tasks = tasks;
        this.studentName = studentName;

        int[] array = {0};
        timer = new Timer(array, durationMinutes * 60);

        //open session save file
        try {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm"));
            writer = new BufferedWriter(new FileWriter(studentName + "_" + time));
            writeAndSave("Session save file\nStudent: " + studentName + "\n" + time + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isOver(){
        if(tasks.size() <= nextTaskIndex){
            writeAndSave("\n====== AFFECT DATA ======\n" + affectData.toString() + "\n");
            writeAndSave("\n====== PAD DATA ======\n" + padData.toString() + "\n");

            return true;
        }
        return false;
    }

//    public static Session createSession(int duration, ArrayList<Task> tasks){
//        if(duration <= 0){
//            throw new IllegalArgumentException("Duration must be at least 1 second.");
//        }
//        if(tasks.size() == 0){
//            throw new IllegalArgumentException("Must have at least one task.");
//        }
//        return new Session(duration, tasks);
//    }

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

    public boolean checkCompletion(String userAnswer){
        int attemptTime = timer.getTimeLeft();
        attemptTimes.add(timer.getInitialTime() - attemptTime);
        answerAttempts.add(userAnswer);
        return tasks.get(nextTaskIndex - 1).checkCompletion(userAnswer, attemptTime);
    }

    //ends the current Task (if there is one) and returns the next task (if there is one)
    public Task nextTask(){
        if(nextTaskIndex != 0){
            writeAndSave("Question " + (nextTaskIndex) + ": " + (taskSwitchTime - timer.getTimeLeft()) + " seconds");
            for(int i = 0; i < answerAttempts.size(); i++){
                writeAndSave("\tAttempt " + (i + 1) + " (" + attemptTimes.get(i) + "s): " + answerAttempts.get(i));
            }
            answerAttempts.clear();
            attemptTimes.clear();
            taskSwitchTime = timer.getTimeLeft();
        }
        nextTaskIndex += 1;
        return tasks.get(nextTaskIndex - 1);
    }

    public Task peekNextTask(){
        return tasks.get(nextTaskIndex);
    }


    private void writeAndSave(String content) {
        try {
            // Write content to the file
            this.writer.write(content);
            this.writer.newLine(); // Add a newline after each line
            // Save the file
            writer.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getTaskNumber(){
        return nextTaskIndex;
    }

    public void linkTimerText(Text timerText){
        timer.setTimerText(timerText);
    }

    //returns the remaining time in the session
//    public int getRemainingTime(){}

    //starts the timer for the session, begins measurements
    public void startSession(){
        //start timer
        timer.startTimer();
        taskSwitchTime = timer.getTimeLeft();
    }

    public void addAffect(String data) {
        affectData.put(timer.getInitialTime() - timer.getTimeLeft(), data);
        System.out.println("added affect to session");
    }
    public void addPAD(String data) {
        padData.put(timer.getInitialTime() - timer.getTimeLeft(), data);
        System.out.println("added pad to session");
    }

//
//    public void endSession(){}
//
//    //records an event that occurs, stores it together with a timestamp
//    public void addEvent(){}
}
