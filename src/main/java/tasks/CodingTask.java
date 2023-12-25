package tasks;

import java.util.Objects;

public class CodingTask implements Task {
    String task;
    String answer; //move this to interface?
    String funCall;
    public CodingTask(String question, String answer, String funCall){
        this.task = question;
        this.answer = answer;
        this.funCall = funCall;
    }


    @Override
    public boolean checkCompletion(String userAnswer, int attemptTime) {
        PythonRunner.createPythonFile(userAnswer + "\n" + funCall);
        System.out.println(userAnswer + "\n" + funCall);
        double output;
        try {
            String ret = PythonRunner.runCode();
            System.out.println(ret);
            output = Double.parseDouble(ret);
            return output == Double.parseDouble(answer);
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
