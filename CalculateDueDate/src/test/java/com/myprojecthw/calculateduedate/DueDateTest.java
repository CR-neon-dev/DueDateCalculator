/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.myprojecthw.calculateduedate;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fulin
 */
public class DueDateTest {
    
    public DueDateTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    
    
    @Test
    public void testIsWeekendMethod() {
        // Test with a Saturday
        LocalDateTime saturday = LocalDateTime.of(2025, Month.MARCH, 8, 10, 0); 
        assertTrue(DueDate.isWeekend(saturday));

        // Test with a Sunday
        LocalDateTime sunday = LocalDateTime.of(2025, Month.MARCH, 9, 10, 0); 
        assertTrue(DueDate.isWeekend(sunday));

        // Test with a weekday
        LocalDateTime wednesday = LocalDateTime.of(2025, Month.MARCH, 5, 10, 0); 
        assertFalse(DueDate.isWeekend(wednesday));
    }
    
}
