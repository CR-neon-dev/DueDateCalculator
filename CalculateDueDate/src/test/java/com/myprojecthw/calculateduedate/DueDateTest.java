/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.myprojecthw.calculateduedate;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
    public void testCalculateDueDateBetweenBuisneesHours()
    {
        //Test to ensure that it will return a date plus however many hours it will be completed by
        // 9:00 AM + 3 hour turn around 
        var result = DueDate.calculateDueDate(LocalDateTime.of(2025,Month.MARCH,6,9,0),3);
        
        // should be = 12:00 pm
        var expected = LocalDateTime.of(2025,Month.MARCH,6,12,0);
        
        assertEquals(expected,result);
    }
    
    @Test
    public void testTimeSubmittedRollingOverToNextBuisnessDay()
    {
        // Tuesday 2:12 pm with 16 hour turn around
        var result = DueDate.calculateDueDate(LocalDateTime.of(2025,Month.MARCH,4,14,12),16);
        
        // Thursday 2:12 pm
        var expected = LocalDateTime.of(2025,Month.MARCH,6,14,12);
        
        assertEquals(expected,result);
    }
    
    @Test
    public void testTimeSubmittedRollingOverToNextBuisnessDayOneMinuteBefore()
    {
        // Tuesday 4:59 pm with 2 hour turn around
        var result = DueDate.calculateDueDate(LocalDateTime.of(2025,Month.MARCH,4,16,59),2);
        
        // Wensday 10:59 pm
        var expected = LocalDateTime.of(2025,Month.MARCH,5,10,59);
        
        assertEquals(expected,result);
    }
    
    @Test
    public void testTimeBetweenBuisnessHours()
    {
        // Thursday 9:00 Am
        var time = LocalDateTime.of(2025,Month.MARCH,6,9,0);
        
        
        var result = DueDate.isBetweenWorkingHours(time);
        
        assertTrue(result);
    }
    
    @Test
    public void testTimeNotBetweenBuisnessHours()
    {
        // Thursday 8:00 Am
        var time = LocalDateTime.of(2025,Month.MARCH,6,8,0);
        
        
        var result = DueDate.isBetweenWorkingHours(time);
        
        assertFalse(result);
    }
    
    @Test
    public void testIsWeekendMethod() {
        // Test with a Saturday
        LocalDateTime saturday = LocalDateTime.of(2025, Month.MARCH, 8, 5, 0); 
        assertTrue(DueDate.isWeekend(saturday));

        // Test with a Sunday
        LocalDateTime sunday = LocalDateTime.of(2025, Month.MARCH, 9, 5, 0); 
        assertTrue(DueDate.isWeekend(sunday));

        // Test with a weekday (wensday)
        LocalDateTime wednesday = LocalDateTime.of(2025, Month.MARCH, 5, 10, 0); 
        assertFalse(DueDate.isWeekend(wednesday));
    }
    
}
