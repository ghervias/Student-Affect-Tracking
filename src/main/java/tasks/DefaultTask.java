package tasks;

import java.util.ArrayList;
import java.util.Objects;

public class DefaultTask implements Task {
    String task;
    String answer; //move this to interface?
    public DefaultTask(String arithmetic, String answer){
        this.task = arithmetic;
        this.answer = answer;
    }


    @Override
    public boolean checkCompletion(String userAnswer, int attemptTime) {
        return userAnswer.equals(answer);
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public String getDescription() {
        return task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultTask that = (DefaultTask) o;
        return Objects.equals(task, that.task) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, answer);
    }
}
