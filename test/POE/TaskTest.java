/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POE;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class TaskTest {

    Task taskTest;

    public TaskTest() {
    }

    @Before
    public void setUp() {
        taskTest = new Task();
    }

    @After
    public void tearDown() {
        taskTest = null;
    }

    //valid task Description
    @Test
    public void testCheckTaskDescription_Valid() {
        String taskDescription = "Technology has transformed our lives, enabling convenience, connectivity, and efficiency. .";
        boolean result = taskTest.checkTaskDescription(taskDescription);
        assertEquals(true,result);
    }

    //Invalid task Description
    @Test
    public void testCheckTaskDescription_InValid() {
        String taskDescription = "Rapid advancements in technology have revolutionized the way we live, work, and communicate. From artificial intelligence and machine learning to virtual reality and blockchain, the possibilities seem endless. With greater connectivity and access to information, we have the opportunity to solve complex problems, drive innovation, and improve the quality of life for people around the globe. However, as technology becomes increasingly integrated into our daily lives, it is essential to navigate the ethical challenges that arise, such as data privacy, security, and the impact on jobs and society. By fostering a responsible and inclusive approach to technology, we can harness its transformative power and create a future that benefits everyone.";
        boolean result = taskTest.checkTaskDescription(taskDescription);
        assertFalse(result);
    }

    @Test
    public void testCreateTaskID() {
      String taskName = "Login Feature";
        int taskNumber = 1;
        String developerLastName = "Harrison";
        String expectedTaskID = "LO:1:SON";
        String taskID = taskTest.createTaskID(taskName, taskNumber, developerLastName);
        assertEquals(expectedTaskID, taskID);
    }

    @Test
    public void testPrintTaskDetails() {
        String trackStatus = "To Do";
        String developer = "Robyn Harrison";
        int taskNumber = 1;
        String taskName = "Login Feature";
        String taskDescription = "Create Login to authenticate users";
        String taskID = "LO:1:SON";
        int taskDuration = 8;

        String expectedDisplay = "Track Status: " + trackStatus + "\n"
                + "Developer Details: " + developer + "\n"
                + "Task numner: " + taskNumber + "\n"
                + "Task name: " + taskName
                + "Task Description: " + taskDescription + "\n"
                + "Task ID: " + taskID + "\n"
                + "Task Duration: " + taskDuration + " hours";

        String display = taskTest.printTaskDetails(trackStatus, developer, taskNumber, taskName, taskDescription, taskID, taskDuration);
        assertEquals(expectedDisplay, display);
    }

    @Test
    public void testReturnTotalHours() {
        int taskDuration = 8;
        int expectedTotalHours = 8;
        int totalHours = taskTest.returnTotalHours(taskDuration);
        assertEquals(expectedTotalHours, totalHours);
    }

}
