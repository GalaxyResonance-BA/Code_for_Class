/**
@author Benjamin Acosta
@version 1.1
Dr. Nguyen
Data Structures and Algorithms Section 01
P1
The problem is to create a program that simulates a basic calculator based on user imput.
Using user imput, the program performs simple arithmetic. After, the user can either do another calculation or quit.
@param args command-line arguments (not used in this program).
Algorithm for SimpleCalculator:
  1. Import the Scanner class to handle user input.
  2. Create the main class and define the main method.
  3. Initialize a Scanner object for reading user inputs.
  4. Set a boolean variable to control the calculation loop.
  5. Enter a while loop to repeatedly perform calculations:
     - Prompt the user to enter the first number.
     - Prompt the user to enter an arithmetic operator (+, -, *, /).
     - Prompt the user to enter the second number.
     - Perform the calculation based on the operator:
         - Addition: Display the sum.
         - Subtraction: Display the difference.
         - Multiplication: Display the product.
         - Division: Check for division by zero and display the quotient or an error message.
         - Invalid Operator: Display an error message.
     - Ask the user if they want to perform another calculation.
         - If "y": Repeat the loop.
         - If "n": Exit the loop.
  6. Display a goodbye message and terminate the program.
*/

import java.util.Scanner;

public class SimpleCalculator
{
  public static void main(String[] args)
  {
	// Create a Scanner object for reading user input.
    Scanner keyboard = new Scanner(System.in);
	// Booblean flag to control the loop for repeated calculations.
	boolean continueCalculating = true;
	
	// Loop to perform calculations until user chooses to quit.
	while(continueCalculating)
	{
	  // Declare variables to store user imputs.
	  int num1_input;  // First number entered by the user.
	  int num2_input;  // Second number entered by the user.
	  String operator_input;  // Arithmetic operator entered by the user.
	
	  // Prompt the user to enter the first number.
	  System.out.print("Enter your first number: ");
	  num1_input = keyboard.nextInt();
	
	  // Prompt the user to enter the arithmetic operator.
	  System.out.print("Enter your operator (+, -, *, /): ");
	  operator_input = keyboard.next();
	
	  // Prompt the user to enter the second number.
	  System.out.print("Enter your second number: ");
	  num2_input = keyboard.nextInt();
	
	  // Perform the calculation based on the operator entered by the user.
	  if(operator_input.equals("+"))
	  {
	    System.out.println(num1_input + " " + operator_input + " " + num2_input + " = "
	            + (num1_input + num2_input));  
	  }
	  else if(operator_input.equals("-"))
	  {
	    System.out.println(num1_input + " " + operator_input + " " + num2_input + " = "
	            + (num1_input - num2_input));
	  }
	  else if(operator_input.equals("*"))
	  {
	    System.out.println(num1_input + " " + operator_input + " " + num2_input + " = "
	            + (num1_input * num2_input));
	  }
	  else if(operator_input.equals("/"))
	  {
	    // Handle division and check for division by zero.
	    if(num2_input != 0)
	    {
		  System.out.println(num1_input + " " + operator_input + " " + num2_input + " = "
	              + (num1_input / num2_input));
	    }
	    else
	    {
		  System.out.println("Division by zero is not allowed.");
	    }
	  }
	  else
	  {
	    // Handle invalid operators.
        System.out.println("Invalid operator.");
	  }
	
	  // Ask the user if they want to perform another calculation.
	  System.out.print("Do you want to perform another calculation? (y/n): ");
      String response = keyboard.next();

      // Exit the loop if the user enters anything other than "y".
	  if (!response.equalsIgnoreCase("y"))
	  {
	    continueCalculating = false;
      }
    }
	
	// Display a goodbye message before exiting the program.
	System.out.println("Goodbye!");
  }
}