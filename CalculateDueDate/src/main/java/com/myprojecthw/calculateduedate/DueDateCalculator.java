/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojecthw.calculateduedate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 * Class that contains methods to calculate a due date
 */
public class DueDateCalculator {
    
    /**
     * Calculates the date a ticket will be completed given a number hours, but only doing work during business hours.
     * @param submittedDate The date the ticket was submitted
     * @param hours How many hours are needed before the ticket is completed
     * @return The date the ticket was completed
     * @throws IllegalArgumentException if date and time outside work hours
     */
    public static LocalDateTime calculateDueDate(LocalDateTime submittedDate, int hours)
    {
        if(isWeekend(submittedDate))
        {
           // Throw if date falls in a weekend
            throw new IllegalArgumentException("Cannot submit during the weekend " + submittedDate.toString() + " ");
        }
        else if(isBetweenWorkingHours(submittedDate) != true)
        {
            // Throw if time isnt between work hours
            throw new IllegalArgumentException("Cannot submit during non work hours " + submittedDate.toString() + " ");
        }
        
        // Conversion from our given LocalDateTime to LocalTime we do this bc we only want the time not the date
        LocalTime currentTime = submittedDate.toLocalTime();
        // Result to be calculated
        LocalDateTime result = submittedDate;
        //Convert the hours needed to complete to minutes
        int hoursInMinutes = hours * 60;
        
        //while hours to complete arent done
        while(hoursInMinutes != 0)
        {
            //Add 1 minute to the currentTime
            currentTime = currentTime.plusMinutes(1);
            
            //Check if the currentTime has reached 5:00 Pm
            if(currentTime == LocalTime.of(17,0))
            {
                // Move to next work day, since we have reached the end of work day 
                result = result.plusDays(1);
                
                //Keep adding until the day isnt a weekend
                while(isWeekend(result))
                {
                    result = result.plusDays(1);
                }
                
                //Set the result to next working day starting at 9:00 AM
                result = LocalDateTime.of(result.getYear(),result.getMonth(),result.getDayOfMonth(),9,0);
                currentTime = result.toLocalTime(); // get the new time without date
            }
            else if((hoursInMinutes - 1) == 0) //if no more minutes need to be added then set the result
            {
                //Set the result to working date and the currentTime to reflect when the work was finalized
                result = LocalDateTime.of(result.getYear(),result.getMonth(),result.getDayOfMonth(),currentTime.getHour(),currentTime.getMinute());
            }
            
            hoursInMinutes = hoursInMinutes - 1; // decrease total thats left
        }
        
        return result;
    }
    
    /**
     * Checks if the given date falls during a weekend (Sat/Sun)
     * @param DateSubmitted
     * @return True if its a weekend, false otherwise
     */
    public static boolean isWeekend(LocalDateTime DateSubmitted)
    {
        if(DateSubmitted.getDayOfWeek() == java.time.DayOfWeek.SATURDAY)
        {
            return true;
        }
        else if(DateSubmitted.getDayOfWeek() == java.time.DayOfWeek.SUNDAY)
        {
            return true;
        } 
        
        return false;
    }
    
    /**
     * Given a time calculates if its between the working hours of 9:00 AM - 5:00 PM
     * @param DateSubmitted Time to evaluate
     * @return true if during work hours, false otherwise
     */
    public static boolean isBetweenWorkingHours(LocalDateTime DateSubmitted)
    {
        LocalTime currentHour = DateSubmitted.toLocalTime();
        LocalTime startDay = LocalTime.of(8,59); // used 8:59 AM since 9:00 AM must be included
        LocalTime endofDay = LocalTime.of(17,0); // 5:00 PM
        
        // if between 9 am and 5 pm return true else false
        return currentHour.isBefore(endofDay) && currentHour.isAfter(startDay);
    }
}
