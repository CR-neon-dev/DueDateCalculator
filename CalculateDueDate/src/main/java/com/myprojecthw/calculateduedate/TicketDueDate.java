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
        
        try {
            LocalDateTime time1 = LocalDateTime.of(2025, Month.MARCH, 6, 9, 0);
            int turnaround = 10;
            LocalDateTime completedTime = DueDateCalculator.calculateDueDate(time1, turnaround);

            System.out.println("Ticket Submitted At: " + time1 + "\nTurn Around: " + turnaround + "\nTime Completed: " + completedTime);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
        
    }
}
