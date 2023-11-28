package tasks;

//interface, can have different types of tasks that will require different inputs
public interface Task {
    // Constants (if any)
    // Example: int MAX_VALUE = 100;


    boolean checkCompletion(String userAnswer, int attemptTime);

    public String getAnswer();

    public String getDescription();

}