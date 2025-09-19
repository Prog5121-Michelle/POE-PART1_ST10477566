package com.mycompany.poe_part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationPageTest {

    @Test
    void testValidUsername() {
        assertTrue(Registration_Page.isValidUsername("kyl_1"),   
            "Welcome <user first name>, <user last name> it is great to see you."); // valid
        assertFalse(Registration_Page.isValidUsername("kyle!!!!!!!"),
                "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length."); // too long
        assertFalse(Registration_Page.isValidUsername("kyle"));   // no underscore
    }

    @Test
    void testValidPassword() {
        assertTrue(Registration_Page.isValidPassword("Ch&&sec@ke99!"),
                "Password successfully catured");   // valid
    }
    
    @Test
    void testInValidPassword() {
        assertFalse(Registration_Page.isValidPassword("password"),
                "Password is not correctly formatted, please ensure that the password contains atleast eight characters, a capital letter, "
                        + "a number, and a special character.");
                    //no uppercase, no number + no special char
        
    }

    @Test
    void testValidCellNumber() {
        assertTrue(Registration_Page.isValidCellNumber("+27838968976"),
                "Cell number successfully captured."); // valid international
    }
    
    @Test
    void testInValidCellNumber() {
        assertFalse(Registration_Page.isValidCellNumber("08966553"),
                "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.");   // valid
        assertFalse(Registration_Page.isValidCellNumber("123"));         // too short
        assertFalse(Registration_Page.isValidCellNumber("abc123"));      // invalid chars
    }

    @Test
    void testRegisterUserSuccess() {
        String result = Registration_Page.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("User registered successfully", result);

        // confirm values saved into static fields
        assertEquals("kyl_1", Registration_Page.Username);
        assertEquals("Ch&&sec@ke99!", Registration_Page.Password);
        assertEquals("Kyle", Registration_Page.FirstName);
        assertEquals("Smith", Registration_Page.LastName);
    }

    @Test
    void testRegisterUserInvalidUsername() {
        // Username is too long and missing underscore
        String result = Registration_Page.registerUser("kyle!!!!!!!", "password", "Jane", "Smith");
        assertEquals("Username is incorrectly formatted", result);
        // static values remain unchanged from last successful registration
        assertEquals(null, Registration_Page.Username);
    }

    @Test
    void testRegisterUserInvalidPassword() {
        // Password has no uppercase, number, or special char
        String result = Registration_Page.registerUser("user_", "abcdefghi", "Alice", "Brown");
        assertEquals("Password does not meet complexity requirements", result);
        // static values remain unchanged from last successful registration
        assertEquals("kyl_1", Registration_Page.Username);
    }

    //@Test
    //void testLoginUserSuccess() {
        // Should pass because we already registered kyl_1 / Ch&&sec@ke99!
        //assertTrue(Registration_Page.loginUser("kyl_1", "Ch&&sec@ke99!"));
    //}

    @Test
    void testLoginUserFailure() {
        assertFalse(Registration_Page.loginUser("wrongUser", "Ch&&sec@ke99!")); // wrong username
        assertFalse(Registration_Page.loginUser("kyl_1", "WrongPass1!")); // wrong password
    }
}
