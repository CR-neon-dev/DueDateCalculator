/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojecthw.calculateduedate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author fulin
 */
public class DueDate {
    
    public static LocalDateTime calculateDueDate(LocalDateTime SubmittedDate, int hours)
    {
        if(isWeekend(SubmittedDate))
        {
           // Returning the same value for now but should probably throw
           return SubmittedDate;
        }
        else if(isBetweenWorkingHours(SubmittedDate) != true)
        {
            // Returning the same value for now but should throw as well 
            return SubmittedDate;
        }
        
        LocalTime startDay = LocalTime.of(9,0);
        LocalTime endofDay = LocalTime.of(17,0);
        LocalTime current = SubmittedDate.toLocalTime();
        LocalDateTime result = SubmittedDate;
        
        int hoursInMinutes = hours * 60;
        
        while(hoursInMinutes != 0)
        {
            current = current.plusMinutes(1);

            if(current == endofDay)
            {
                result = result.plusDays(1);

                while(isWeekend(result))
                {
                    result = result.plusDays(1);
                }
                
                result = LocalDateTime.of(result.getYear(),result.getMonth(),result.getDayOfMonth(),9,0);
                current = result.toLocalTime();
            }
            else if((hoursInMinutes - 1) == 0)
            {
                result = LocalDateTime.of(result.getYear(),result.getMonth(),result.getDayOfMonth(),current.getHour(),current.getMinute());
            }
            
            
            
            hoursInMinutes = hoursInMinutes - 1;
        }
        
        return result;
    }
    
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
    
    public static boolean isBetweenWorkingHours(LocalDateTime DateSubmitted)
    {
        LocalTime currentHour = DateSubmitted.toLocalTime();
        LocalTime startDay = LocalTime.of(8,59);
        LocalTime endofDay = LocalTime.of(17,0);
        
        // if between 9 am and 5 pm return true else false
        return currentHour.isBefore(endofDay) && currentHour.isAfter(startDay);
    }
}
