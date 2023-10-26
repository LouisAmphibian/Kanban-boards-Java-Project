package POE;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        //DECLARING variables
        String username, password, firstName, lastName;

        //callin classes and their methods
        Login log = new Login();
        Task task = new Task();
        TaskManager taskManager = new TaskManager();

        String storeFirst = null, storeLast = null, storeUsername = null, storePassword = null;  //declared variaable to store the first name,last name, password and username for case 2

        //Using scanner to capture user input
        Scanner scan = new Scanner(System.in);

        while (true) { //using while loop to loop the question, ansewrs and conditon (Until the conditon true)
            //Displaying options for the user to choose
            String welcome = JOptionPane.showInputDialog("Welcome! Please choose the following:\n"
                    + "1-Create an accoint\n"
                    + "2-Login into your account\n"
                    + "3-EXIT");
            int response = Integer.parseInt(welcome);

            //Using switch case so the user can be able to choose 
            switch (response) {
                case 1: //When user chooses 1 (Create an account)

                    firstName = JOptionPane.showInputDialog("Please enter your first name:");
                    log.setFirstName(firstName);
                    
                    lastName = JOptionPane.showInputDialog("Please enter your last name:");
                    log.setLastName(lastName);
                    
                    while (firstName.isEmpty() || lastName.isEmpty()) { //when firstName or lastName are not entered it will reset
                        firstName = JOptionPane.showInputDialog("Please enter your first name:");
                        lastName = JOptionPane.showInputDialog("Please enter your last name:");
                    }

                    username = JOptionPane.showInputDialog("Please enter username.Username must contains: \n"
                            + "-an underscore\n"
                            + "-and is no more than 5 characters:");
                    log.setUsername(username);

                    //Conditions to check the username is correct
                    if (log.checkUserName(username)) {

                        password = JOptionPane.showInputDialog("Please enter password. Password meets the following: \n"
                                + "-At least 8 characters long\n"
                                + "-Contain a capital letter\n"
                                + "-Contain a number\n"
                                + "- Contain a special character:");
                        log.setPassword(password);
                        
                        //Condition to check the password is correct and store user's imput
                        if (log.checkPasswordComplexity(password)) {

                            //Store the user's password and username for the login option. Also stores the user's first and last name
                            storeFirst = log.getFirstName();
                            storeLast = log.getLastName();
                            storeUsername = log.getUsername();
                            storePassword = log.getPassword();

                        }

                        //Will display when username or password is incorrect or correct resterimg user
                        String displayRegistration = log.registerUser(username, password);
                        JOptionPane.showMessageDialog(null, displayRegistration);

                    }

                    break;

                case 2: //When user chooses 2 (Login into an account)

                    //if statement if the user wants to login without creating/registering an account
                    if (storeUsername == null || storePassword == null || storeFirst == null || storeLast == null) {
                        JOptionPane.showMessageDialog(null, "No account has been created yet. Please create an account first to login");
                    } //Asking the user for their previous input (username and passwrd)
                    else {
                        String inputUser = JOptionPane.showInputDialog("Please enter your Username:");

                        String inputPass = JOptionPane.showInputDialog("Please enter your Password:");

                        //Condition statement to check if the username and password match and allows user to login
                        boolean loginUserStatus = log.loginUser(inputUser, inputPass, storePassword, storeUsername, storeFirst, storeLast);
                        String displayReturnLoginStatus = log.returnLoginStatus(inputUser, inputPass, storePassword, storeUsername, storeFirst, storeLast, loginUserStatus);

                        //Display the login status
                        JOptionPane.showMessageDialog(null, displayReturnLoginStatus);

                        /*TASK 2
                        After everything is cleared the user can then add task
                         */
                        //A if condition will check if the username and password works and allow the user to add task
                        if (loginUserStatus) {

                            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

                            //will repeat until it is true
                            while (true) {
                                String taskOption = JOptionPane.showInputDialog("Please choose an option:\n"
                                        + "1- Add tasks \n"
                                        + "2- Show report\n"
                                        + "3- Quit \n");
                                int response2 = Integer.parseInt(taskOption);

                                //The user will able to choose the option after being prompt
                                switch (response2) {
                                    case 1:
                                            int numberOfTasks;
                                            boolean validInput =false;
                                            do{
                                            String numTask = JOptionPane.showInputDialog("How many tasks do you want to add?");
                                            numberOfTasks = Integer.parseInt(numTask);
                                           
                                            
                                            if (numberOfTasks > 0) {
                                                validInput = true;
                                                
                                                //A for loop to print out the number of tasks the user would like to add
                                                for (int i = 0; i < numberOfTasks; i++) {

                                                    //adding task number and will be incremented
                                                    int taskNumber = (i + 1);

                                                    String taskName = JOptionPane.showInputDialog("Task Number: " + taskNumber
                                                            + "\n Task Name: ");

                                                    //will ask the user to enter the correct amounnt till task is successfully capture
                                                    //boolean validDescription = false;
                                                    String taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters:");
                                                    
                                                    
                                                    //check the task description conditions
                                                    boolean validDescription = false;
                                                    while (!validDescription) {
                                                        validDescription = task.checkTaskDescription(taskDescription);

                                                        //checks if it is not true user will have to re-enter taskDescription
                                                        if (!validDescription) {
                                                            taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters:");
                                                        }
                                                    }

                                                    //adding the Developer name and last name
                                                    String developerFirstName = JOptionPane.showInputDialog("Enter Developer's first name: ");

                                                    String developerLastName = JOptionPane.showInputDialog("Enter Developer's last name: ");

                                                    String developer = developerFirstName + " " + developerLastName;
                                                    //adding the duration
                                                    String taskHours = JOptionPane.showInputDialog("Task Duration (in hours)");
                                                    int taskDuration = Integer.parseInt(taskHours);

                                                    //declaring for the total amount of hours
                                                    int totalOfHours = task.returnTotalHours(taskDuration); //add the duration to the total in the Task class

                                                    //creating the task ID and calling it in the method
                                                    String taskID = task.createTaskID(taskName, taskNumber, developerLastName);

                                                    //menu for track Status
                                                    String statusChoice = JOptionPane.showInputDialog("Select Status \n"
                                                            + "1-To Do \n"
                                                            + "2-Done\n"
                                                            + "3-Doing");

                                                    int statusOption = Integer.parseInt(statusChoice);

                                                    //Store the track Status output
                                                    String trackStatus;
                                                    switch (statusOption) {
                                                        case 1:
                                                            trackStatus = "To Do";
                                                            break;

                                                        case 2:
                                                            trackStatus = "Done";
                                                            break;

                                                        case 3:
                                                            trackStatus = "Doing";
                                                            break;

                                                        default:
                                                            trackStatus = "Not Known";
                                                            break;
                                                    }

                                                    //Displaying the task details 
                                                    String display = task.printTaskDetails(developer, trackStatus, taskNumber, taskName, taskDescription, taskID, taskDuration);
                                                    JOptionPane.showMessageDialog(null, display);

                                                    //populaating the array
                                                    taskManager.insertTaskValues(developer, taskName, taskID, taskDuration, trackStatus);
                                                }
                                                //display done tasks status
                                                taskManager.displayDoneTaskStatus();
                                                
                                                //display class with longest duration
                                                taskManager.displayOfClassWithLongestDuration();
                                                
                                                //Search for task by task name
                                                String searchName = JOptionPane.showInputDialog("Search Task Name: ");
                                                taskManager.searchForTaskName(searchName);
                                                
                                                //Search for task assigned to the developer
                                                String searchDeveloper = JOptionPane.showInputDialog("Input developer's full name to search all assigned tasks");
                                                taskManager.searchAllDeveloperTasks(searchDeveloper);
                                                
                                                //Delete a task by task name
                                                String deleteTask = JOptionPane.showInputDialog(null, "Input task (by task name)you want to delete: ");
                                                taskManager.deleteTaskByTaskName(deleteTask);
                                                
                                            } else if (numberOfTasks == 0) {
                                                validInput = true;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Invalid input. Number of tasks must be greater than or equal to zero.");
                                            }
                                            }while (!validInput);
                                            break;
                                

                                    case 2:
                                         //Display full report
                                          taskManager.displayCapturedTasks();
                                        break;

                                    //exit the task option
                                    case 3:
                                        JOptionPane.showMessageDialog(null, "Thank you for visiting! Hope to see you soon!");
                                        System.exit(0);
                                        break;

                                    //when the user enters the wrong task option
                                    default:
                                        JOptionPane.showMessageDialog(null, "Invaild option please slecect correct option");

                                }
                            }
                        }
                    }
                    break;

                //when user wants to exit
                case 3:
                    JOptionPane.showMessageDialog(null, "Thank you for visiting! Hope to see you soon!");
                    System.exit(0);

                //when the user enters the wrong option
                default:
                    JOptionPane.showMessageDialog(null, "Invaild option please slecect correct option");
            }
        }

    }
}

