package com.chriscarr.romannumerals;

import java.util.Arrays;
import java.util.Scanner;

import com.chriscarr.romannumerals.enums.ModeType;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final int minRange = 1;
	private static final int maxRange = 3999;
	
    public static void main( String[] args )
    {
    	ModeType mt;
    	mt = ((args.length == 0) ? ModeType.GUI: ModeType.CLI); //if param is passed through the program was started with cli. created enums for readability
    	
    	
    	int number = (Integer) ((mt == ModeType.GUI) ? askForNumber() : args[0]); //retrieve number from either the CLI or the GUI. TODO: VALIDATE CLI INPUT

        RomanNumeral rn = new RomanNumeral(minRange, maxRange);
        
        String romanNumeral = rn.generate(number);
        
        System.out.println(); //print new line in case anything printed to screen from previous object did not
        System.out.println("-------------------"); //looks cool?
        System.out.print("The Roman Numeral of "+number+" is "+romanNumeral);
        
    }

    
    /**
     * 
     * @return int between 1 & 3999
     */
	private static int askForNumber() {
		
		String enterText = "Please enter an integer betweem "+minRange+" & "+maxRange+": ";
		
		Scanner in = new Scanner(System.in);
		
		int inputNumber = -1; // -1 is going to be used as a false flag in this program
		
		boolean correctInput = false;
		
		System.out.println(enterText);
		
		while(correctInput == false)
		{
			try
			{
				inputNumber = in.nextInt();
				
				if(inputNumber >= 1 && inputNumber <= 3999)
				{
					correctInput = true;
				}
				else
				{
					System.out.println("That integer is out of bounds. "+enterText);
				}
			}
			catch(Exception e)
			{
				in.next();
				System.out.println("That is not a valid integer. "+enterText);
			}
		}
		
		in.close();
		
		return inputNumber;
	}
}
