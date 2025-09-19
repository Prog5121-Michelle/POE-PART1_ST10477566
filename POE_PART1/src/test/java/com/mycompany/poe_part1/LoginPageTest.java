package com.mycompany.poe_part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {

    @Test
    void testSuccessfulLogin() {
        // First, register a valid user
        Registration_Page.registerUser("user_", "Strong1@", "John", "Doe");

        // Now try logging in with the same credentials
        boolean result = Registration_Page.loginUser("user_", "Strong1@");

        assertTrue(result, "Login should succeed with correct username and password");
    }

    @Test
    void testFailedLoginWithWrongPassword() {
        // Register a valid user
        Registration_Page.registerUser("user_", "Strong1@", "John", "Doe");

        // Try login with the wrong password
        boolean result = Registration_Page.loginUser("user_", "WrongPass1!");

        assertFalse(result, "Login should fail when using the wrong password");
    }

    @Test
    void testFailedLoginWithWrongUsername() {
        // Register a valid user
        Registration_Page.registerUser("user_", "Strong1@", "John", "Doe");

        // Try login with wrong username
        boolean result = Registration_Page.loginUser("wrong_", "Strong1@");

        assertFalse(result, "Login should fail when using the wrong username");
    }
}
