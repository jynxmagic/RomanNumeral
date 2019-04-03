package com.chriscarr.romannumerals;

import com.chriscarr.romannumerals.exception.IntegerOutOfBoundsException;

public class Validator 
{
	
	private int minRange;
	private int maxRange;
	
	Validator(int minRange, int maxRange)
	{
		this.minRange = minRange;
		this.maxRange = maxRange;
	}
	
	
    /**
     * 
     * @param string usually passed from the command line initialization of the program as a parameter
     * @return integer between 1 & 3999
     */
    public int validateInput(String string) throws Exception
    {
		//number passed from cli
    	
    	int number = 0;
    	try
    	{
    		number = Integer.parseInt(string);
    	}
    	catch(Exception e)
    	{
    		System.out.println("Problem occured while translating number");
    		e.printStackTrace();
    		System.exit(0);
    	}
    	
    	if(number < minRange || number > maxRange)
    	{
    		throw new IntegerOutOfBoundsException(number);
    	}
    	
		return number;
	}
}
