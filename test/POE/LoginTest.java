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


public class LoginTest {

    //reference fo login class
    Login loginTest;

    public LoginTest() {
    }

    //obj creation
    @Before
    public void setUp() {
        loginTest = new Login();
    }

    //like a contructor
    @After
    public void tearDown() {
        loginTest = null;
    }

    @Test
    public void testCheckUserName_Valid() {
        String username = "kyle_";
        boolean result = loginTest.checkUserName(username);
        assertEquals(true, result);
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        String password = "Ch&&sec@ke99!";
        boolean result = loginTest.checkPasswordComplexity(password);
        assertEquals(true, result);
    }

    @Test
    public void testRegisterUserName_Valid() {
        String username = "kyle_";
        boolean result = loginTest.registerUserName(username);
        assertEquals(true, result);
    }

    @Test
    public void testRegisterPasswordComplexity_Valid() {
        String password = "Ch&&sec@ke99!";
        boolean result = loginTest.registerPasswordComplexity(password);
        assertEquals(true, result);
    }

    @Test
    public void testRegisterUser_Valid() {
        String password = "Ch&&sec@ke99!";
        String username = "kyle_";
        String approvedMessage = "You registered succesfully";;

        String result = loginTest.registerUser(username, password);
        assertEquals(approvedMessage, result);
    }

    @Test
    public void testLoginUser_Valid() {
        String inputUser = "kyle_";
        String inputPass = "Ch&&sec@ke99!";
        String storePassword = "Ch&&sec@ke99!";
        String storeUsername = "kyle_";
        String storeFirst = "Kyle";
        String storeLast = "Chase";
  
        boolean result = loginTest.loginUser(inputUser, inputPass, storePassword, storeUsername, storeFirst, storeLast);
        assertEquals(true,result);
    }

    @Test
    public void testReturnLoginStatus_Valid() {
        String inputUser = "kyle_";
        String inputPass = "Ch&&sec@ke99!";
        String storePassword = "Ch&&sec@ke99!";
        String storeUsername = "kyle_";
        String storeFirst = "Kyle";
        String storeLast = "Chase";
        boolean loginUserStatus = loginTest.loginUser(inputUser, inputPass, storePassword, storeUsername, storeFirst, storeLast);
        String approvedMessage = "Sucessful login \n" + "Welcome " + storeFirst + ", " + storeLast + " it is great to see you again.";
        
        String result = loginTest.returnLoginStatus(inputUser, inputPass, storePassword, storeUsername, storeFirst, storeLast, loginUserStatus);
        assertEquals(approvedMessage,result);
    }
    
    //invalid 
    @Test
    public void testCheckUserName_InValid() {
        String username = "kyle!!!!!!!";
        boolean result = loginTest.checkUserName(username);
        assertEquals(false, result);
    }

    @Test
    public void testCheckPasswordComplexity_InValid() {
        String password = "password";
        boolean result = loginTest.checkPasswordComplexity(password);
        assertEquals(false, result);
    }

    @Test
    public void testRegisterUserName_InValid() {
        String username = "kyle!!!!!!!";
        boolean result = loginTest.registerUserName(username);
        assertEquals(false, result);
    }

    @Test
    public void testRegisterPasswordComplexity_InValid() {
        String password = "password";
        boolean result = loginTest.registerPasswordComplexity(password);
        assertEquals(false, result);
    }

    @Test
    public void testRegisterUser_InValid() {
        String password = "password";
        String username = "kyle!!!!!!!";
        String errorMessage = "The username or password incorrect";

        String result = loginTest.registerUser(password, username);
        assertEquals(errorMessage, result);
    }

    @Test
    public void testLoginUser_InValid() {
        String inputUser = "kyle!!!!!!!";
        String inputPass = "password";
        String storePassword = "Ch&&sec@ke99!";
        String storeUsername = "kyle_";
        String storeFirst = "Kyle";
        String storeLast = "Chase";
  
        boolean result = loginTest.loginUser(inputUser, inputPass, storePassword, storeUsername, storeFirst, storeLast);
        assertEquals(false,result);
    }

    @Test
    public void testReturnLoginStatus_InValid() {
        String inputUser = "kyle!!!!!!!";
        String inputPass = "password";
        String storePassword = "Ch&&sec@ke99!";
        String storeUsername = "kyle_";
        String storeFirst = "Kyle";
        String storeLast = "Chase";
        boolean loginUserStatus = loginTest.loginUser(inputUser, inputPass, storePassword, storeUsername, storeFirst, storeLast);
        String errorMessage = "Failed login \n" + "Username or password incorrect, please try again";
        
        String result = loginTest.returnLoginStatus(inputUser, inputPass, storePassword, storeUsername, storeFirst, storeLast, loginUserStatus);
        assertEquals(errorMessage,result);
    }

}
