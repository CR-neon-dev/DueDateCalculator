# DueDateCalculator
Due Date Calculator for a Ticket System HW Problem 

## DueDateCalculator   

contains the main logic and implemented function:

### calculateDueDate(LocalDateTime, int) 

Calculates the due date for a ticket submitted in LocalDateTime because it contains the full date and time. While the turn around is an int. This will calculate the when ticket will be completed, if it goes past the allowed working hours the function will just rollover remaining time left to be completed in the next business day. 

Ex. if not complete by Friday then rolls it over the remaining to be worked on Monday and so on.

Also throws if a ticket was submitted during a weekend or outside business hours. In the main implementation I catched the exceptions to not cause a crash and gave a detailed exception message. 

# DueDateCalculatorTests

This class contains the various automated test I made while developing the funtion, using the Junit package with normal and edge cases. I followed TTD as much as I could and that can be checked in the commit history. 
