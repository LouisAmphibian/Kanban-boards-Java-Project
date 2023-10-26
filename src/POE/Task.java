package POE;

import javax.swing.JOptionPane;

public class Task {

    private String trackStatus, developerFirstName, developerLastName,   taskName, taskDescription, taskID , developer;
    private int totalHours, taskNumber, taskDuration;
    
    boolean checkTaskDescription(String taskDescription) {
        if (taskDescription.length() < 50) {
            JOptionPane.showMessageDialog(null,"Task successfully captured");
            return true;
        } else {

            JOptionPane.showMessageDialog(null,"Please enter a task description of less than 50 characters");
            return false;
        }
    }

    //Task ID generator method
    String createTaskID(String taskName, int taskNumber, String developerLastName) {
        String firstTwoLetters = taskName.substring(0, 2).toUpperCase();
        String lastThreeLetters = developerLastName.substring(developerLastName.length() - 3).toUpperCase();
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    }

    String printTaskDetails(String trackStatus, String developer, int taskNumber, String taskName, String taskDescription, String taskID, int taskDuration) {
        String taskDisplay = "Track Status: " + trackStatus + "\n"
                + "Developer Details: " + developer + "\n"
                + "Task numner: " + taskNumber + "\n"
                + "Task name: " + taskName
                + "Task Description: " + taskDescription + "\n"
                + "Task ID: " + taskID + "\n"
                + "Task Duration: " + taskDuration + " hours";
        return taskDisplay;
    }

    public int returnTotalHours(int taskDuration) {
        int totalOfHours = 0;
        totalHours = totalHours + taskDuration;
        return totalHours;
    }
    
    // Setter method for taskDescriptions
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    // Getter method for taskDescription
    public String getTaskDescription() {
        return taskDescription;
    }
}
