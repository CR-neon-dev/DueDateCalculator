/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojecthw.calculateduedate;
import java.time.LocalDateTime;
/**
 *
 * @author fulin
 */
public class DueDate {
    
    public static LocalDateTime calculateDueDate(LocalDateTime SubmittedDate, int hours)
    {
        if(isWeekend(SubmittedDate))
        {
           return SubmittedDate;
        }
        
        return SubmittedDate.plusHours(hours);
        
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
        int currentHour = DateSubmitted.getHour();
        
        // if between 9 am and 5 pm return true else false
        if(currentHour >= 9 && currentHour< 17)
            return true;
        else
            return false;
    }
}
