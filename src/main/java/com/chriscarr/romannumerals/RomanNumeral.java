package com.chriscarr.romannumerals;

import com.chriscarr.romannumerals.exception.IntegerOutOfBoundsException;

public class RomanNumeral implements RomanNumeralInterface {
	
	int minRange;
	int maxRange;
	
	RomanNumeral(int minRange, int maxRange)
	{
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	/**
	 * 
	 * @param number between 1 & 3999
	 * @return String of Roman Numerals
	 */
	public String generate(int number)
	{
		if(number > maxRange || number < minRange)
		{
			try 
			{
				throw new IntegerOutOfBoundsException(number);
			}
			catch (IntegerOutOfBoundsException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	    return this.convertToRoman(number);
	}
	
	private String convertToRoman(int arabic)
	{
		
		
		return null;
	}

}