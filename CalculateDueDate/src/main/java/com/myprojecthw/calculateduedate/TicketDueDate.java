/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myprojecthw.calculateduedate;

import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author fulin
 */
public class TicketDueDate {

    public static void main(String[] args) {

        //Variable Init
         LocalDateTime time;
         int turnaround;
         LocalDateTime completedTime;
         
        try {
            time = LocalDateTime.of(2025, Month.MARCH, 6, 9, 0);
            turnaround = 10;
            completedTime = DueDateCalculator.calculateDueDate(time, turnaround);

            System.out.println("Ticket Submitted At: " + time + "\nTurn Around: " + turnaround + "\nTime Completed: " + completedTime);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
         try {
            time = LocalDateTime.of(2025, Month.MARCH, 9, 3, 0);
            turnaround = 3;
            completedTime = DueDateCalculator.calculateDueDate(time, turnaround);

            System.out.println("Ticket Submitted At: " + time + "\nTurn Around: " + turnaround + "\nTime Completed: " + completedTime);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         
         
         try {
            time = LocalDateTime.of(2025, Month.MARCH, 6, 19, 0);
            turnaround = 7;
            completedTime = DueDateCalculator.calculateDueDate(time, turnaround);

            System.out.println("Ticket Submitted At: " + time + "\nTurn Around: " + turnaround + "\nTime Completed: " + completedTime);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         
         try {
            time = LocalDateTime.of(2025, Month.MARCH, 14, 10, 0);
            turnaround = 7;
            completedTime = DueDateCalculator.calculateDueDate(time, turnaround);

            System.out.println("Ticket Submitted At: " + time + "\nTurn Around: " + turnaround + "\nTime Completed: " + completedTime);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
