/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojecthw.calculateduedate;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author fulin
 */
public class DueDate {
    
//    public static LocalDate calculateDueDate(LocalDate SubmittedDate, int hours)
//    {
//        
//    }
    
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
}
