package POE;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//extended program
public class TaskManager extends Task {

    //To be able to store the array in a list so it is possible to add, remove and accessing data
    private List<String> taskDeveloperArray;
    private List<String> taskNameArray;
    private List<String> taskIdArray;
    private List<Integer> taskDurationArray;
    private List<String> taskStatusArray;

    //constructor for the varibles that will be used to manage data in Task Manager
    public TaskManager() {
        taskDeveloperArray = new ArrayList<>();
        taskNameArray = new ArrayList<>();
        taskIdArray = new ArrayList<>();
        taskDurationArray = new ArrayList<>();
        taskStatusArray = new ArrayList<>();
    }

    //method adding all the Task contents to the array
    public void insertTaskValues(String developer, String taskName, String taskID, int taskDuration, String trackStatus) {
        //adding the users variables to the array
        taskDeveloperArray.add(developer);
        taskNameArray.add(taskName);
        taskIdArray.add(taskID);
        taskDurationArray.add(taskDuration);
        taskStatusArray.add(trackStatus);
    }

    //method to display done task status
    public void displayDoneTaskStatus() {
        JOptionPane.showMessageDialog(null, "Tasks that are Done");
        //loop to check for tasks done
        for (int i = 0; i < taskStatusArray.size(); i++) {
            if (taskStatusArray.get(i).equalsIgnoreCase("done")) {
                JOptionPane.showMessageDialog(null, "Done Tasks: " + "\n"
                        + "Develvoper : " + taskDeveloperArray.get(i) + "\n"
                        + "Task Names: " + taskNameArray.get(i) + "\n"
                        + "Task Duration: " + taskDurationArray.get(i));
            }
        }
    }

    //method to display (Developer and Duration of the class with the longest duration  
    public void displayOfClassWithLongestDuration() {
        int maxDuration = 0;
        int maxDurationIndex = -1;

        //loop to access the developer with the longest duration
        for (int i = 0; i < taskDurationArray.size(); i++) { //runs through the loop first then stores the longest duration and exits 
            if (taskDurationArray.get(i) > maxDuration) {
                maxDuration = taskDurationArray.get(i);
                maxDurationIndex = i;
            }
        }

        //checks if maxDurationIndex is not below -1 if not then prints out
        if (maxDurationIndex != (-1)) {
            JOptionPane.showMessageDialog(null, "Class with the longest Duration:" + "\n"
                    + "Developer: " + taskDeveloperArray.get(maxDurationIndex) + "\n"
                    + "Task Duration: " + taskDurationArray.get(maxDurationIndex));
        } else {
            JOptionPane.showMessageDialog(null, "There are no tasks found.");
        }
    }
    //method to search task name

    public void searchForTaskName(String searchName) {
        boolean foundTask = false;
        for (int i = 0; i < taskNameArray.size(); i++) {
            if (taskNameArray.get(i).equalsIgnoreCase(searchName)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + taskNameArray.get(i) + "\n"
                        + "Developer: " + taskDeveloperArray.get(i) + "\n"
                        + "Task Status: " + taskStatusArray.get(i));
                foundTask = true;
            }
        }
        if (!foundTask) {
            JOptionPane.showMessageDialog(null, "There are no tasks found with this name: " + searchName);
        }
    }

    //Method to search for all tasks assigned to a developer and display the Task Name and Task Status
    public void searchAllDeveloperTasks(String searchDeveloper) {
        boolean foundTask = false;
        for (int i = 0; i < taskDeveloperArray.size(); i++) {
            if (taskDeveloperArray.get(i).equalsIgnoreCase(searchDeveloper)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + taskNameArray.get(i) + "\n"
                        + "Track Status: " + taskStatusArray.get(i));
                        foundTask = true;
            }
        }
        if (!foundTask) {
            JOptionPane.showMessageDialog(null, "There is no tasks assigned to this developer: " + searchDeveloper);
        }
    }

    //method to delete a task using the Task Name.
    public void deleteTaskByTaskName(String deleteTask) {
        boolean foundTask = false;
        for (int i = 0; i < taskNameArray.size(); i++) {
            if (taskNameArray.get(i).equalsIgnoreCase(deleteTask)) {
                //using the remove method to delete in the arrays
                taskDeveloperArray.remove(i);
                taskNameArray.remove(i);
                taskIdArray.remove(i);
                taskDurationArray.remove(i);
                taskStatusArray.remove(i);
                foundTask = true;
            }
        }
        if (foundTask) {
            JOptionPane.showMessageDialog(null, "Task sussessfully deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "Task sussessfully deleted.");
        }
    }

    //method Display a report that lists the full details of all captured tasks
    public void displayCapturedTasks() {
        for (int i = 0; i < taskNameArray.size(); i++) {
            JOptionPane.showMessageDialog(null, "Task Name: " + taskNameArray.get(i) + "\n"
                    + "Task ID: " + taskIdArray.get(i) + "\n"
                    + "Developer: " + taskDeveloperArray.get(i) + "\n"
                    + "Task Duration: " + taskDurationArray.get(i) + "\n"
                    + "Task Status: " + taskStatusArray.get(i));
        }
    }
}

