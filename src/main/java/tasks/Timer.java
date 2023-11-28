package tasks;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.ArrayList;

public class Timer {
    private int initialTime;
    private int seconds;
    private Timeline timeline;
    private boolean timerInit = false;
    private Text timerText;


    public Timer(int[] timeRemaining, int setSeconds) {
        initialTime = setSeconds;
        seconds = setSeconds;
        // Create a timeline that triggers an event every second
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Update the seconds and display in the label
                seconds--;
                timeRemaining[0] = seconds;
                if(timerInit){
                    String textString = "Time remaining: " + (int)Math.floor(seconds/60) + ":" + seconds % 60;
                    timerText.setText(textString);
                }
            }
        }));

        // Set the timeline to repeat indefinitely
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public int getTimeLeft(){
        return this.seconds;
    }

    public int getInitialTime(){
        return this.initialTime;
    }
    public void startTimer() {
        // Start the timeline
        timeline.play();
    }
    public void setTimerText(Text timerText){
        this.timerText = timerText;
        timerInit = true;
    }
}
