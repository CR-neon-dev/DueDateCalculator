/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.myprojecthw.calculateduedate;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DueDateCalculatorTest {
    
    
    @Test
    public void testCalculateDueDateInWeekendThrowsException()
    {
        //Test to ensure that it will throw if a weekend is entered
         assertThrows(IllegalArgumentException.class, () -> {
            DueDateCalculator.calculateDueDate(LocalDateTime.of(2025, Month.MARCH, 8, 9, 0), 3);
        });

    }
    
    @Test
    public void testCalculateDueDateOutsideWorkHoursThrowsException()
    {
        //Test to ensure that it will throw if a weekend is entered
         assertThrows(IllegalArgumentException.class, () -> {
            DueDateCalculator.calculateDueDate(LocalDateTime.of(2025, Month.MARCH, 8, 5, 0), 3);
        });

    }
    
    @Test
    public void testCalculateDueDateBetweenBuisneesHours()
    {
        //Test to ensure that it will return a date plus however many hours it will be completed by
        // 9:00 AM + 3 hour turn around 
        var result = DueDateCalculator.calculateDueDate(LocalDateTime.of(2025,Month.MARCH,6,9,0),3);
        
        // should be = 12:00 pm
        var expected = LocalDateTime.of(2025,Month.MARCH,6,12,0);
        
        assertEquals(expected,result);
    }
    
    @Test
    public void testTimeSubmittedRollingOverToNextBuisnessDay()
    {
        // Tuesday 2:12 pm with 16 hour turn around
        var result = DueDateCalculator.calculateDueDate(LocalDateTime.of(2025,Month.MARCH,4,14,12),16);
        
        // Thursday 2:12 pm
        var expected = LocalDateTime.of(2025,Month.MARCH,6,14,12);
        
        assertEquals(expected,result);
    }
    
    @Test
    public void testTimeSubmittedRollingOverToNextBuisnessDayOneMinuteBefore()
    {
        // Tuesday 4:59 pm with 2 hour turn around
        var result = DueDateCalculator.calculateDueDate(LocalDateTime.of(2025,Month.MARCH,4,16,59),2);
        
        // Wensday 10:59 pm Expected
        var expected = LocalDateTime.of(2025,Month.MARCH,5,10,59);
        
        assertEquals(expected,result);
    }
    
    @Test void testTimeSubmittedRollingOverOnFriday()
    {
         // Friday 2:12 pm with 16 hour turn around
        var result = DueDateCalculator.calculateDueDate(LocalDateTime.of(2025,Month.MARCH,7,14,12),16);
        
        // Tuesday 10:12 am Expected
        var expected = LocalDateTime.of(2025,Month.MARCH,11,14,12);
        
        assertEquals(expected,result);
    }
    
    @Test
    public void testTimeBetweenBuisnessHours()
    {
        // Thursday 9:00 Am
        var time = LocalDateTime.of(2025,Month.MARCH,6,9,0);
        
        //Should Assert True
        assertTrue(DueDateCalculator.isBetweenWorkingHours(time));
    }
    
    @Test
    public void testTimeNotBetweenBuisnessHours()
    {
        // Thursday 8:00 Am
        var time = LocalDateTime.of(2025,Month.MARCH,6,8,0);
        
        //Should Assert False
        assertFalse(DueDateCalculator.isBetweenWorkingHours(time));
    }
    
    @Test
    public void testIsWeekendMethod() {
        // Test with a Saturday
        LocalDateTime saturday = LocalDateTime.of(2025, Month.MARCH, 8, 5, 0); 
        assertTrue(DueDateCalculator.isWeekend(saturday));

        // Test with a Sunday
        LocalDateTime sunday = LocalDateTime.of(2025, Month.MARCH, 9, 5, 0); 
        assertTrue(DueDateCalculator.isWeekend(sunday));

        // Test with a weekday (wensday)
        LocalDateTime wednesday = LocalDateTime.of(2025, Month.MARCH, 5, 10, 0); 
        assertFalse(DueDateCalculator.isWeekend(wednesday));
    }
    
}
