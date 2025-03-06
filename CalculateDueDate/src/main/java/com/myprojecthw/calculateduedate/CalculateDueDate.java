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
public class CalculateDueDate {

    public static void main(String[] args) {
        
        LocalDateTime time1 = LocalDateTime.of(2025,Month.MARCH,6,9,0);
        System.out.println("things");
        
       
        System.out.println(
                DueDate.calculateDueDate(LocalDateTime.of(2025,Month.MARCH,6,9,0),3).toString());
        
        
    }
}
