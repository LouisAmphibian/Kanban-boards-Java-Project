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
public class TaskManagerTest {
    TaskManager taskManagerTest;
    public TaskManagerTest() {
    }
    
    @Before
    public void setUp() {
      taskManagerTest = new TaskManager();
    }
    
    @After
    public void tearDown() {
        taskManagerTest = null;
    }

    @Test
    public void testInsertTaskValues() {
        // Add test data
        taskManagerTest.insertTaskValues("Mike Smith", "Create Login", "1", 5, "To Do");
        taskManagerTest.insertTaskValues("Edward Harrison", "Create Add Features", "2", 8, "Doing");
        taskManagerTest.insertTaskValues("Samantha Paulson", "Create Reports", "3", 2, "Done");
        taskManagerTest.insertTaskValues("Glenda Oberholzer", "Add Arrays", "4", 11, "To Do");

        // Expected developer array
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};

        // Get the actual developer array
        String[] actualDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};


        // Check if the developer array contains the expected data
        assertArrayEquals(expectedDevelopers, actualDevelopers);
    }

    @Test
    public void testDisplayDoneTaskStatus() {
            }

    @Test
    public void testDisplayOfClassWithLongestDuration() {
        String expectedOutput = "Glenda Oberholzer, 11";
        String actualOutput = taskManagerTest.displayOfClassWithLongestDuration();
        assertEquals(expectedOutput, actualOutput);
        
        // Assert that the expected and actual output are equal
        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void testSearchForTaskName() {
        String taskName = "Create Login";
        String expectedOutput = "Mike Smith, Create Login";
        String actualOutput = taskManagerTest
    }

    @Test
    public void testSearchAllDeveloperTasks() {
    }

    @Test
    public void testDeleteTaskByTaskName() {
    }

    @Test
    public void testDisplayCapturedTasks() {
    }
    
}
