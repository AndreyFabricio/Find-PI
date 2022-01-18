import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Andrey Fabricio
 * Github: https://github.com/AndreyFabricio
 * LinkedIn: https://www.linkedin.com/in/andrey-fabricio/
 * 
 * This project generates up to the Nth decimal place of PI
 * The PI value is calculated using the Chudnovsky algorithm
 * Chudnovsky algorithm: https://www.craig-wood.com/nick/articles/pi-chudnovsky/
 * 
 * Last update: 18/01/2022
 */

public class Main {
	
	static int factorial(int n){    
		// Calculates the factorial value of n
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n * factorial(n-1));    
		 } 
	
	public static void main(String[] args) {
		
		// Gets the Nth value from the user	
		
		int Nth = 0;
		
		System.out.print("Type how many decimal places of PI you want (max 11): ");
		Scanner scanner = new Scanner(System.in);
		
        try {
            Nth = Integer.parseInt(scanner.nextLine());
        } catch(NumberFormatException nfe) {
            System.err.println("The value is not a valid integer");
        }
		
        if (Nth > 11) 
        	System.out.print("Cannot generate more than 11 decimals of PI");
        
        // Finds PI using the Chudnovsky algorithm       

		double x, pi, deno;
		x = pi = deno = 0;
		
		for (int i = 0; i <= Nth; i ++) {
			x = (Math.pow(-1,  i))*(factorial(6*i))*(13591409+545140134*i);
			deno = factorial(3*i)*(Math.pow(factorial(i), 3))*(Math.pow(640320, 3*i));
			pi += x/deno;
		}      
		
		pi = pi * 12 / Math.pow(640320, 1.5);
		pi = 1/pi;
		
		// Prints the result with the decimal place limitation
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(Nth);
		System.out.print(df.format(pi));
		
	}

}
