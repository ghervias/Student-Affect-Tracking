package tasks;

import java.util.Objects;

public class CodingTask implements Task {
    String task;
    String answer; //move this to interface?
    public CodingTask(String arithmetic, String answer){
        this.task = arithmetic;
        this.answer = answer;
    }


    @Override
    public boolean checkCompletion(String userAnswer, int attemptTime) {
        PythonRunner.createPythonFile(userAnswer);
        System.out.println(userAnswer);
        String output;
        try {
            String ret = PythonRunner.runCode();
            System.out.println(ret);
            output = ret;
            return output.equals(answer);
        }
        catch (Exception runnerException){
            runnerException.printStackTrace();
        }
        return false;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public String fxmlLocation() {
        return "/fxml/PythonTask.fxml";
    }

    @Override
    public String getDescription() {
        return task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodingTask that = (CodingTask) o;
        return Objects.equals(task, that.task) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, answer);
    }
}
